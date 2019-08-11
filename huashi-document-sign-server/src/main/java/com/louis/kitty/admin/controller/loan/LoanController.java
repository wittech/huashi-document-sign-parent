/**
 * 
 */
package com.louis.kitty.admin.controller.loan;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.admin.model.OterPersonnel;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.LoanBasisService;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;
import com.louis.kitty.core.http.HttpResult;

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
	
	
}
