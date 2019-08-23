package com.louis.kitty.admin.sevice.impl;

import com.alibaba.fastjson.JSON;
import com.louis.kitty.admin.dao.LoanCheckDocMapper;
import com.louis.kitty.admin.dao.PostLoanCheckMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.admin.model.PostLoanCheck;
import com.louis.kitty.admin.office.PersonalLoansChecklistTool;
import com.louis.kitty.admin.sevice.LoanCheckDocService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * ---------------------------
 *  (LoanCheckDocServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanCheckDocServiceImpl extends AbstractDocService implements LoanCheckDocService {

	@Resource
	private LoanCheckDocMapper loanCheckDocMapper;
	@Resource
	private PostLoanCheckMapper postLoanCheckMapper;
	@Autowired
	private PersonalLoansChecklistTool personalLoansChecklistTool;

	private DocCommonModel pickupModel(Long loanBasisId) {
		LoanBasis loanBasis = getLoanBais(loanBasisId);
		if (loanBasis == null) {
			log.warn("Can not find any data by id[{}]", loanBasisId);
			return null;
		}

		DocCommonModel model = new DocCommonModel();
		model.setLoanBasis(loanBasis);

		// 相关人信息数据
		setRelatedPersonnelInformations(model);

		// 借贷业务信息
		setLoanBusinessInformation(model);

		// 设置合同信息
		setContractInformation(model);

		return model;
	}

	@Override
	public int born(Long loanCheckId) throws Exception {
		if (loanCheckId == null) {
			throw new IllegalArgumentException("参数为空");
		}

		PostLoanCheck postLoanCheck =postLoanCheckMapper.findById(loanCheckId);
		if(postLoanCheck == null) {
			log.warn("postLoanCheck is null by loanCheckId[{}]", loanCheckId);
			return 0;
		}

		DocCommonModel model = pickupModel(postLoanCheck.getLoanBasisId());
		if (model == null) {
			log.warn("pickupModel by loanCheckId[{}] null", postLoanCheck.getLoanBasisId());
			return 0;
		}

		model.setPostLoanCheck(postLoanCheck);

		long startTime = System.currentTimeMillis();
		try {

			// 清除原有记录,后续要考虑持续追加的类型，不能直接删除
			loanCheckDocMapper.deleteByLoanCheckId(loanCheckId);

			List<Future<Boolean>> futureList = asyncExecute(model);

			return getResult(futureList);
		} finally {
			log.info("build notice doc process cost {} ms", (System.currentTimeMillis() - startTime));
		}
	}

	@Override
	protected List<Future<Boolean>> asyncExecute(DocCommonModel model) {
		List<Future<Boolean>> futureList = new ArrayList<>();
		try {
			log.info("async building check docs start...");
			futureList.add(personalLoansChecklistTool.execute(model));
		} catch (Exception e) {
			log.error("async execute check doc build failed by model[{}]", JSON.toJSONString(model), e);
		}

		log.info("async building check docs end...");
		return futureList;
	}

	private List<String> findFileNamesByIds(String loanCheckDocIds, boolean isPdf) {
		if (StringUtils.isEmpty(loanCheckDocIds)) {
			log.error("loanCheckDocIds[{}] is empty", loanCheckDocIds);
			return null;
		}

		String[] loanDocIdArray = loanCheckDocIds.split(",");
		List<LoanCheckDoc> loanDocList = loanCheckDocMapper.findByIds(Arrays.asList(loanDocIdArray));

		List<String> fileNames = new ArrayList<>();
		for (LoanCheckDoc loanDoc : loanDocList) {
			if (loanDoc == null) {
				continue;
			}

			if (isPdf) {
				fileNames.add(loanDoc.getPdfPath());
			} else {
				fileNames.add(loanDoc.getDocPath());
			}
		}

		return fileNames;
	}

	@Override
	public ResponseEntity<InputStreamResource> download(String loanCheckDocIds) {
		List<String> fileNames = findFileNamesByIds(loanCheckDocIds, false);
		if (CollectionUtils.isEmpty(fileNames)) {
			log.warn("Can not find any data by loanCheckDocIds[{}]", loanCheckDocIds);
			return null;
		}

		ResponseEntity<InputStreamResource> resourceResponseEntity = getZipFile(fileNames);
		if(resourceResponseEntity != null) {
			addOneIfDownload(loanCheckDocIds);
		}

		return resourceResponseEntity;
	}

	@Override
	public String print(String loanCheckDocIds) {
		List<String> fileNames = findFileNamesByIds(loanCheckDocIds, true);
		if (CollectionUtils.isEmpty(fileNames)) {
			log.warn("Can not find any data by loanCheckDocIds[{}]", loanCheckDocIds);
			return null;
		}

		String pdfUrl = getPrintPdf(fileNames, "");
		if(StringUtils.isNotEmpty(pdfUrl)) {
			addOneIfPrint(loanCheckDocIds);
		}

		return pdfUrl;
	}

	@Override
	public List<LoanCheckDoc> queryByLoanCheckId(Long loanCheckId) {
		return loanCheckDocMapper.findByLoanCheckId(loanCheckId);
	}

	private void addOneIfDownload(String loanCheckDocIds) {
		if (StringUtils.isEmpty(loanCheckDocIds)) {
			return;
		}

		loanCheckDocMapper.addOneIfDownload(Arrays.asList(loanCheckDocIds.split(",")));
	}

	private void addOneIfPrint(String loanCheckDocIds) {
		if (StringUtils.isEmpty(loanCheckDocIds)) {
			return;
		}

		loanCheckDocMapper.addOneIfPrint(Arrays.asList(loanCheckDocIds.split(",")));
	}

	@Override
	public int save(LoanCheckDoc record) {
		if(record.getId() == null || record.getId() == 0) {
			return loanCheckDocMapper.add(record);
		}
		return loanCheckDocMapper.update(record);
	}

	@Override
	public int delete(LoanCheckDoc record) {
		return loanCheckDocMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanCheckDoc> records) {
		for(LoanCheckDoc record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanCheckDoc findById(Long id) {
		return loanCheckDocMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanCheckDocMapper);
	}
	
}
