package org.linagora.linshare.core.facade.webservice.common.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class OrganizationRegisterDto {
	
	@ApiModelProperty(value = "regid")
	private String regId;
	
	@ApiModelProperty(value = "user1Dto")
	private User1Dto user1dto;
	
	@ApiModelProperty(value = "organizationDto")
	private OrganizationDto organizationdto;
	
	
	
	
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public User1Dto getUser1dto() {
		return user1dto;
	}
	public void setUser1dto(User1Dto user1dto) {
		this.user1dto = user1dto;
	}
	public OrganizationDto getOrganizationdto() {
		return organizationdto;
	}
	public void setOrganizationdto(OrganizationDto organizationdto) {
		this.organizationdto = organizationdto;
	}
	
	
	
	

}
