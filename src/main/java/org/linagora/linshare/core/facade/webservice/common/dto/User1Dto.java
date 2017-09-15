package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.linagora.linshare.core.domain.entities.User1;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "User1Dto")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")
public class User1Dto {
	
	
	@ApiModelProperty(value = "id")
	private String id;	
	
	@ApiModelProperty(value = "salutation")
	private String salutation;
	
	@ApiModelProperty(value = "firstName")
	private String firstName;
	
	@ApiModelProperty(value = "lastName")
	private String lastName;
	
	@ApiModelProperty(value = "middleName")
	private String middleName;
	
	@ApiModelProperty(value = "emailId")
	private String emailId;
	
	@ApiModelProperty(value = "password")
	private String password;
	
	@ApiModelProperty(value = "phoneNumber")
	private String phoneNumber;
	
	private Date createdDate;
	private Date modifiedDate;
	private boolean isActive;
	private boolean isDisable;
	private String organizationId;
	
	private String roleId;
	
	
	public User1Dto() {
		super();
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSalutation() {
		System.out.println("User1 getSalutation "+salutation);
		return salutation;
	}
	public void setSalutation(String salutation) {
		System.out.println("User1 setSalutation "+salutation);
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("User1 setFirstName "+firstName);
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
		System.out.println("User1 setcreatedDate"+createdDate);
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
	public boolean isDisable() {
		return isDisable;
	}
	public void setDisable(boolean isDisable) {
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
	
	
	
	public User1Dto(User1 entity) {
		firstName = entity.getFirstName();
		middleName = entity.getMiddleName();
		lastName = entity.getLastName();
		emailId = entity.getEmailId();
		password = entity.getPassword();
		phoneNumber = entity.getPhoneNumber();
		createdDate = entity.getCreatedDate();
		modifiedDate = entity.getModifiedDate();
		isActive = entity.getisActive();
		organizationId = entity.getOrganizationId();
	}
	
	

}
