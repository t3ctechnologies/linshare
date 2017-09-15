package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.linagora.linshare.core.domain.entities.Registration;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@XmlRootElement(name = "Registration")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")
public class RegistrationDto {
	
	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "name")
	private String name;
	
	@ApiModelProperty(value = "emailId")
	private String emailId;
	
	@ApiModelProperty(value = "companyName")
	private String companyName;
	
	@ApiModelProperty(value = "phoneNumber")
	private String phoneNumber;
	
	private Date createdDate;
	private Date modifiedDate;
	private boolean isDemoCreated;
	private boolean isActive;
	
	
	public RegistrationDto() {
		super();
	}
	
	public RegistrationDto(Registration reg) {
		this.id = reg.getId();
		this.name = reg.getName();
		this.emailId = reg.getEmailId();
		this.companyName = reg.getCompanyName();
		this.phoneNumber = reg.getPhoneNumber();
		this.createdDate = reg.getCreatedDate();
		this.modifiedDate = reg.getModifiedDate();
		this.isActive = reg.getIsActive();
		this.isDemoCreated = reg.getIsDemoCreated();
	}
	
	public void setDetails(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean getisDemoCreated() {
		return isDemoCreated;
	}
	public void setisDemoCreated(boolean isDemoCreated) {
		this.isDemoCreated = isDemoCreated;
	}
	public boolean getisActive() {
		return isActive;
	}
	public void setisActive(boolean isActive) {
		this.isActive = isActive;
	}

}
