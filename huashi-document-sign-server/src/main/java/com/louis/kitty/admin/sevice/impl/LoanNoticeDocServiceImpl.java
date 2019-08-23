package com.louis.kitty.admin.sevice.impl;

import com.alibaba.fastjson.JSON;
import com.louis.kitty.admin.dao.CollectionNoticeMapper;
import com.louis.kitty.admin.dao.LoanNoticeDocMapper;
import com.louis.kitty.admin.model.CollectionNotice;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.admin.model.LoanNoticeDoc;
import com.louis.kitty.admin.office.OverdueBorrowerNoticeTool;
import com.louis.kitty.admin.office.OverdueGuarantorNoticeTool;
import com.louis.kitty.admin.sevice.LoanNoticeDocService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 *  (LoanNoticeDocServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanNoticeDocServiceImpl extends AbstractDocService implements LoanNoticeDocService {

	@Value("${storage.model.download}")
	private String docDownloadFileTarget;

	@Value("${storage.model.print}")
	private String docPrintFileTarget;

	@Value("${storage.model.domain}")
	private String docDomain;

	@Resource
	private LoanNoticeDocMapper loanNoticeDocMapper;
	@Resource
	private CollectionNoticeMapper collectionNoticeMapper;

	@Autowired
	private OverdueBorrowerNoticeTool overdueBorrowerNoticeTool;
	@Autowired
	private OverdueGuarantorNoticeTool overdueGuarantorNoticeTool;

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
	public int born(Long loanNoticeId) throws Exception {
		if (loanNoticeId == null) {
			throw new IllegalArgumentException("参数为空");
		}

		CollectionNotice collectionNotice =collectionNoticeMapper.findById(loanNoticeId);
		if(collectionNotice == null) {
			log.warn("collectionNotice is null by loanNoticeId[{}]", loanNoticeId);
			return 0;
		}

		DocCommonModel model = pickupModel(collectionNotice.getLoanBasisId());
		if (model == null) {
			log.warn("pickupModel by loanNoticeId[{}] null", collectionNotice.getLoanBasisId());
			return 0;
		}

		model.setCollectionNotice(collectionNotice);

		long startTime = System.currentTimeMillis();
		try {

			// 清除原有记录,后续要考虑持续追加的类型，不能直接删除
			loanNoticeDocMapper.deleteByLoanNoticeId(loanNoticeId);

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
			log.info("async building notice docs start...");
			futureList.add(overdueBorrowerNoticeTool.execute(model));
			futureList.add(overdueGuarantorNoticeTool.execute(model));
		} catch (Exception e) {
			log.error("async execute notice doc build failed by model[{}]", JSON.toJSONString(model), e);
		}

		log.info("async building notice docs end...");
		return futureList;
	}

	private List<String> findFileNamesByIds(String loanNoticeDocIds, boolean isPdf) {
		if (StringUtils.isEmpty(loanNoticeDocIds)) {
			log.error("loanNoticeDocIds[{}] is empty", loanNoticeDocIds);
			return null;
		}

		String[] loanDocIdArray = loanNoticeDocIds.split(",");
		List<LoanNoticeDoc> loanDocList = loanNoticeDocMapper.findByIds(Arrays.asList(loanDocIdArray));

		List<String> fileNames = new ArrayList<>();
		for (LoanNoticeDoc loanDoc : loanDocList) {
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
	public ResponseEntity<InputStreamResource> download(String loanNoticeDocIds) {
		List<String> fileNames = findFileNamesByIds(loanNoticeDocIds, false);
		if (CollectionUtils.isEmpty(fileNames)) {
			log.warn("Can not find any data by loanNoticeDocIds[{}]", loanNoticeDocIds);
			return null;
		}

		ResponseEntity<InputStreamResource> resourceResponseEntity = getZipFile(fileNames);
		if(resourceResponseEntity != null) {
			addOneIfDownload(loanNoticeDocIds);
		}

		return resourceResponseEntity;
	}

	@Override
	public String print(String loanNoticeDocIds) {
		List<String> fileNames = findFileNamesByIds(loanNoticeDocIds, true);
		if (CollectionUtils.isEmpty(fileNames)) {
			log.warn("Can not find any data by loanNoticeDocIds[{}]", loanNoticeDocIds);
			return null;
		}

		String pdfUrl = getPrintPdf(fileNames, "");
		if(StringUtils.isNotEmpty(pdfUrl)) {
			addOneIfPrint(loanNoticeDocIds);
		}

		return pdfUrl;
	}

	@Override
	public List<LoanNoticeDoc> queryByLoanNoticeId(Long loanNoticeId) {
		return loanNoticeDocMapper.findByLoanNoticeId(loanNoticeId);
	}

	private void addOneIfDownload(String loanNoticeDocIds) {
		if (StringUtils.isEmpty(loanNoticeDocIds)) {
			return;
		}

		loanNoticeDocMapper.addOneIfDownload(Arrays.asList(loanNoticeDocIds.split(",")));
	}

	private void addOneIfPrint(String loanNoticeDocIds) {
		if (StringUtils.isEmpty(loanNoticeDocIds)) {
			return;
		}

		loanNoticeDocMapper.addOneIfPrint(Arrays.asList(loanNoticeDocIds.split(",")));
	}

	@Override
	public int save(LoanNoticeDoc record) {
		if(record.getId() == null || record.getId() == 0) {
			return loanNoticeDocMapper.add(record);
		}
		return loanNoticeDocMapper.update(record);
	}

	@Override
	public int delete(LoanNoticeDoc record) {
		return loanNoticeDocMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanNoticeDoc> records) {
		for(LoanNoticeDoc record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanNoticeDoc findById(Long id) {
		return loanNoticeDocMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanNoticeDocMapper);
	}
	
}
