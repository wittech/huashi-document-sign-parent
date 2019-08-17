/**
 * 
 */
package com.louis.kitty.admin.controller.loan;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	/**
	 *1、保存基础信息 
	 * @param record
	 * @return
	 */
	@PreAuthorize("hasAuthority('loan:add') AND hasAuthority('loan:edit')")
	@PostMapping(value = "/saveBasis")
	public HttpResult saveBasis(@RequestBody LoanBasis record) {
		record.setCreateTime(new Date());
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
		record.setCreateTime(new Date());
		return HttpResult.ok(relatedPersonnelInformationService.save(record));
	}
	
	/**
	 * 3、保存其他相关人
	 * @param record
	 * @return
	 */
	@PostMapping(value="/saveOterBorrower")
	public HttpResult saveOterBorrower(@RequestBody OterPersonnel record) {
		if(record.getRelatedPersonnelInformation() !=null){
			for(RelatedPersonnelInformation red : record.getRelatedPersonnelInformation()){
				red.setLoanBasisId(Long.valueOf(record.getLoanBasisId()));
				relatedPersonnelInformationService.save(red);
			}
		}
		return HttpResult.ok(1);
	}
	
	/**
	 * 4、保存抵押物
	 * @param record
	 * @return
	 */
	@PostMapping(value="/savePawn")
	public HttpResult savePawn(@RequestBody Pawn record) {
		return HttpResult.ok(pawnService.save(record));
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
		return HttpResult.ok(personalLoanSurveyReportService.save(record));
	}
	
	/**
	 * 8、保存合同信息
	 * @param record
	 * @return
	 */
	@PostMapping(value="/saveContractInformation")
	public HttpResult saveContractInformation(@RequestBody ContractInformation record) {
		record.setCreateTime(new Date());
		return HttpResult.ok(contractInformationService.save(record));
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
	
}
