/**
 * 
 */
package com.louis.kitty.admin.controller.loan;

import java.util.Date;

import com.louis.kitty.admin.model.LoanFinalAuditInfo;
import com.louis.kitty.admin.sevice.impl.LoanFinalAuditInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.louis.kitty.admin.model.ContractInformation;
import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.admin.model.LoanBusinessInformation;
import com.louis.kitty.admin.model.OterPersonnel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.PersonalLoanSurveyReport;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.ContractInformationService;
import com.louis.kitty.admin.sevice.LoanBasisService;
import com.louis.kitty.admin.sevice.LoanBusinessInformationService;
import com.louis.kitty.admin.sevice.LoanDocService;
import com.louis.kitty.admin.sevice.PawnService;
import com.louis.kitty.admin.sevice.PersonalLoanSurveyReportService;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;
import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

/**
 * 贷款管理
 * @author lz
 *
 */
@RestController
@RequestMapping("loan")
public class LoanController {

	@Autowired
	private LoanBasisService loanBasisService;
	//相关人员信息表
	@Autowired
	private RelatedPersonnelInformationService relatedPersonnelInformationService;
	@Autowired
	private PawnService pawnService;
	@Autowired
	private LoanBusinessInformationService loanBusinessInformationService;
	@Autowired
	private PersonalLoanSurveyReportService personalLoanSurveyReportService;
	@Autowired
	private ContractInformationService contractInformationService;
	@Autowired
	private LoanDocService loanDocService;
    @Autowired
    private LoanFinalAuditInfoService loanFinalAuditInfoService;
	
	/**
	 *1、保存基础信息 
	 * @param record
	 * @return
	 */
	@PreAuthorize("hasAuthority('loan:add') AND hasAuthority('loan:edit')")
	@PostMapping(value = "/saveBasis")
	public HttpResult saveBasis(@RequestBody LoanBasis record) {
		loanBasisService.save(record);
		return HttpResult.ok(record.getId());
	}
	
	/**
	 * 2、保存借款人
	 * @param record
	 * @return
	 */
	@PostMapping(value="/saveBorrower")
	public HttpResult saveBorrower(@RequestBody RelatedPersonnelInformation record) {
		int i = relatedPersonnelInformationService.save(record);
		if(i>0){
			LoanBasis l = new LoanBasis();
			l.setId(record.getLoanBasisId());
			l.setStatus(2);
			loanBasisService.update(l);
		}
		return HttpResult.ok(i);
	}
	
	/**
	 * 3、保存其他相关人
	 * @param record
	 * @return
	 */
	@PostMapping(value="/saveOterBorrower")
	public HttpResult saveOterBorrower(@RequestBody OterPersonnel record) {
		if(record.getRelatedPersonnelInformation() !=null && record.getRelatedPersonnelInformation().size()>0){
			for(RelatedPersonnelInformation red : record.getRelatedPersonnelInformation()){
				red.setLoanBasisId(Long.valueOf(record.getLoanBasisId()));
				relatedPersonnelInformationService.save(red);
			}
		}else{
			relatedPersonnelInformationService.remove(Long.valueOf(record.getLoanBasisId()));
		}
		LoanBasis l = new LoanBasis();
		l.setId(Long.valueOf(record.getLoanBasisId()));
		l.setStatus(3);
		loanBasisService.update(l);
		return HttpResult.ok(1);
	}
	
	/**
	 * 4、保存抵押物
	 * @param record
	 * @return
	 */
	@PostMapping(value="/savePawn")
	public HttpResult savePawn(@RequestBody Pawn record) {
		int i = pawnService.save(record);
		if(i>0){
			LoanBasis l = new LoanBasis();
			l.setId(Long.valueOf(record.getLoanBasisId()));
			l.setStatus(4);
			loanBasisService.update(l);
		}
		return HttpResult.ok(i);
	}
	
	/**
	 * 根据基础id获取相关人员信息
	 * @param loanBasisId
	 * @return
	 */
	@GetMapping(value="/findByBaseIdList")
	public HttpResult findByBaseIdList(@RequestParam Long loanBasisId) {
		return HttpResult.ok(relatedPersonnelInformationService.findByBaseIdList(loanBasisId));
	}
	
	/**
	 * 5、保存贷款业务信息
	 * @param record
	 * @return
	 */
	@PostMapping(value="/saveLoanBusiness")
	public HttpResult saveLoanBusiness(@RequestBody LoanBusinessInformation record) {
		int i = loanBusinessInformationService.save(record);
		if(i>0){
			LoanBasis l = new LoanBasis();
			l.setId(Long.valueOf(record.getLoanBasisId()));
			l.setStatus(5);
			loanBasisService.update(l);
		}
		return HttpResult.ok(loanBusinessInformationService.save(record));
	}

	/**
	 * 7、保存个人报告信息
	 * @param record
	 * @return
	 */
	@PostMapping(value="/savePersonalLoanSurvey")
	public HttpResult savePersonalLoanSurvey(@RequestBody PersonalLoanSurveyReport record) {
		record.setCreateTime(new Date());
		int i = personalLoanSurveyReportService.save(record);
		if(i>0){
			LoanBasis l = new LoanBasis();
			l.setId(Long.valueOf(record.getLoanBasisId()));
			l.setStatus(7);
			loanBasisService.update(l);
		}
		return HttpResult.ok();
	}
	
	/**
	 * 8、保存合同信息
	 * @param record
	 * @return
	 */
	@PostMapping(value="/saveContractInformation")
	public HttpResult saveContractInformation(@RequestBody ContractInformation record) {
		int i =contractInformationService.save(record);
		if(i>0){
			LoanBasis l = new LoanBasis();
			l.setId(Long.valueOf(record.getLoanBasisId()));
			l.setStatus(7);
			loanBasisService.update(l);
		}
		return HttpResult.ok();
	}

    /**
     * 8、保存最终审批
     * @param record
     * @return
     */
    @PostMapping(value="/saveFinalAudit")
    public HttpResult saveFinalAudit(@RequestBody LoanFinalAuditInfo record) {
        loanFinalAuditInfoService.save(record);
        return HttpResult.ok();
    }


	
	 /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(loanBasisService.findPage(pageRequest));
	}
	
	/**
	 * 根据id获取对象信息
	 * @param id
	 * @return
	 */
	@GetMapping(value="/getById")
	public HttpResult getById(@RequestParam Long id) {
		return HttpResult.ok(loanBasisService.findById(id));
	}
	
	/**
	 * 根据基础信息表id 查询所有 借贷文档信息
	 * @param loanBasisId
	 * @return
	 */
	@GetMapping(value="/queryByLoanBasisId")
    public HttpResult queryByLoanBasisId(@RequestParam Long loanBasisId) {
		return HttpResult.ok(loanDocService.queryByLoanBasisId(loanBasisId));
    }
	
	/**
	 * 根据基础信息id 生成文档
	 * @param loanBasisId
	 * @return
	 */
	@GetMapping(value="/born")
    public HttpResult born(@RequestParam Long loanBasisId) {
		try {
			return HttpResult.ok(loanDocService.born(loanBasisId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpResult.ok(0);
    }
	
	/**
	 * 根据基础id获取 引用房产 和土地信息
	 * @param loanBasisId
	 * @return
	 */
	@GetMapping(value="/findByLoanBasisIdList")
    public HttpResult findByLoanBasisIdList(@RequestParam Long loanBasisId) {
		return HttpResult.ok(loanBasisService.findByLoanBasisIdList(loanBasisId));
    }
	
	/**
	 * 根据id查询对象信息
	 * @param id
	 * @return
	 */
	@GetMapping(value="/getByKeyId")
	public HttpResult getByKeyId(@RequestParam Long id) {
		return HttpResult.ok(loanBasisService.findById(id));
	}


	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "下载借贷文件", httpMethod = "GET", produces = "application/json;charset=UTF-8")
	public Object download(@RequestParam String loanDocIds) {
		return loanDocService.download(loanDocIds);
	}

	@RequestMapping(value = "/print")
	@ApiOperation(value = "打印借贷文件")
	public String print(@RequestParam String loanDocIds, String watermark) {
		return loanDocService.print(loanDocIds, watermark);
	}
	
}
