package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModel;


@XmlRootElement(name = "Registration")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")
public class RegistrationDto {
	
	private String id;
	private String name;
	private String emailId;
	private String companyName;
	private String phoneNumber;
	private Date createdDate;
	private Date modifiedDate;
	private boolean isDemoCreated;
	private boolean isActive;
	private String role;
	
	public RegistrationDto() {
//		this.name = "constructor name";
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	

}
