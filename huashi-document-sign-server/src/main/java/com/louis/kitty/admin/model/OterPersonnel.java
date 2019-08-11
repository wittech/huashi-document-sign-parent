/**
 * 
 */
package com.louis.kitty.admin.model;

import java.util.List;

/**
 * 其他相关人
 * 
 * @author 15858
 *
 */
public class OterPersonnel {
	private String loanBasisId;
	private List<RelatedPersonnelInformation> relatedPersonnelInformation;
	
	public String getLoanBasisId() {
		return loanBasisId;
	}

	public void setLoanBasisId(String loanBasisId) {
		this.loanBasisId = loanBasisId;
	}

	public List<RelatedPersonnelInformation> getRelatedPersonnelInformation() {
		return relatedPersonnelInformation;
	}

	public void setRelatedPersonnelInformation(List<RelatedPersonnelInformation> relatedPersonnelInformation) {
		this.relatedPersonnelInformation = relatedPersonnelInformation;
	}

}
