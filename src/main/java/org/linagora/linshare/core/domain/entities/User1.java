package org.linagora.linshare.core.domain.entities;

import java.util.Date;

import org.linagora.linshare.core.facade.webservice.common.dto.User1Dto;

public class User1 {
	
	private String id;
	private String salutation;
	private String firstName;
	private String lastName;
	private String middleName;
	private String emailId;
	private String password;
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	private String phoneNumber;
	private Date createdDate;
	private Date modifiedDate;
	private boolean isActive;
	private boolean isDisable;
	private String organizationId;
	
	private String roleId;
	
	
	
	
	
	
	public User1() {
		super();
	}
	
	public User1(User1Dto entity) {
		firstName = entity.getFirstName();
		middleName = entity.getMiddleName();
		lastName = entity.getLastName();
		emailId = entity.getEmailId();
		password = entity.getPassword();
		phoneNumber = entity.getPhoneNumber();
		createdDate = entity.getCreatedDate();
		modifiedDate = entity.getModifiedDate();
		isActive = entity.getisActive();
		System.out.println("User1 constructor setOrganizationId "+entity.getOrganizationId());
		organizationId = entity.getOrganizationId();
		salutation = entity.getSalutation();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public boolean getisActive() {
		return isActive;
	}
	public void setisActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean getisDisable() {
		return isDisable;
	}
	
	
	public void setisDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
	
	
	

}
