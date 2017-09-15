package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.Validate;
import org.linagora.linshare.core.domain.entities.OrganizationAccess;
import org.linagora.linshare.core.exception.BusinessException;

import com.wordnik.swagger.annotations.ApiModelProperty;
@XmlRootElement(name = "OrganizationAccess")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")
public class OrganizationAccessDto {

	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "moduleId")
	private String moduleId;
	
	@ApiModelProperty(value = "statusId")
	private String statusId;
	
	@ApiModelProperty(value = "organizationId")
	private String organizationId;
	
	@ApiModelProperty(value = "subscriptionId")
	private String subscriptionId;
	
//	@ApiModelProperty(value = "userId")
//	private String userId;
//	@ApiModelProperty(value = "role")
//	private String role;
//	
	private Date createdDate;
	private Date modifiedDate;
	private boolean isdemoCreated;
	private boolean isActive;
	

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	
	

	public OrganizationAccessDto() {
		super();
	}
	
	public OrganizationAccessDto(String moduleId, String organizationId, String status, String subsId ){
		this.moduleId = moduleId;
		this.organizationId = organizationId;
		this.statusId = status;
		this.subscriptionId = subsId;
		Date date = new Date();
		this.createdDate = date;
		this.modifiedDate = date;
	}
	
	public OrganizationAccessDto(OrganizationAccess reg) {
		this.id = reg.getId();
//		this.isActive = reg.getisActive();
//		this.isdemoCreated = reg.isIsdemoCreated();
		this.moduleId = reg.getModuleId();
//		this.userId = reg.getUserId();
		this.modifiedDate = reg.getModifiedDate();
		this.organizationId = reg.getOrganizationId();
		this.subscriptionId = reg.getSubscriptionId();
		this.statusId = reg.getStatusId();
	}
	
	public void setDetails(String id, String organizationId) {
		this.organizationId = organizationId;
		this.id = id;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

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

	public boolean isIsdemoCreated() {
		return isdemoCreated;
	}

	public void setIsdemoCreated(boolean isdemoCreated) {
		this.isdemoCreated = isdemoCreated;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void validateMe() throws BusinessException {
		Validate.notEmpty(moduleId, "Missing required field ModuleId");
		Validate.notEmpty(organizationId, "Missing required field OrganizationId");
		Validate.notEmpty(subscriptionId, "Missing required field StatusId");
		Validate.notEmpty(statusId, "Missing required field SubscriptionId");
	}
}
