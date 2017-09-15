package org.linagora.linshare.core.facade.webservice.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;


@XmlRootElement(name = "OrganizationRegisterDto")
public class OrganizationRegisterDto {
	@ApiModelProperty(value = "regId")
	private String regId;
	
	@ApiModelProperty(value = "user1Dto")
	private User1Dto user1Dto;
	
	@ApiModelProperty(value = "organizationDto")
	private OrganizationDto organizationDto;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrganizationRegisterDto() {
		super();
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public User1Dto getUser1Dto() {
		return user1Dto;
	}

	public void setUser1Dto(User1Dto user1Dto) {
		this.user1Dto = user1Dto;
	}

	public OrganizationDto getOrganizationDto() {
		return organizationDto;
	}

	public void setOrganizationDto(OrganizationDto organizationDto) {
		this.organizationDto = organizationDto;
	}
	
	

}
