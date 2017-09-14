package org.linagora.linshare.core.domain.entities;

import java.util.Date;

import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;

public class Registration {
	
	private String id;
	private String name;
	private String companyName;
	private String emailId;
	private String phoneNumber;
	private Date createdDate;
	private Date modifiedDate;
	private boolean isDemoCreated;
	private boolean isActive;
	
	
	
	public Registration() {
		super();
	}
	
	public Registration(RegistrationDto rdto) {
		this.name = rdto.getName();
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public boolean getIsDemoCreated() {
		return isDemoCreated;
	}
	public void setIsDemoCreated(boolean isDemoCreated) {
		this.isDemoCreated = isDemoCreated;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
