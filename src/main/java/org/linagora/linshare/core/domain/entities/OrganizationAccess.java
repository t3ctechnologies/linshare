package org.linagora.linshare.core.domain.entities;

import java.util.Date;

public class OrganizationAccess {

	
	private String id;
	private String moduleId;
	private String organizationId;
	private String subscriptionId;
//	private boolean isdemoCreated;
	private String statusId;
//	private String userId;
	private Date createdDate;
	private Date modifiedDate;
//	private boolean isActive;
//	private String role;
	
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
	
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
//	public boolean isIsdemoCreated() {
//		return isdemoCreated;
//	}
//	public void setIsdemoCreated(boolean isdemoCreated) {
//		this.isdemoCreated = isdemoCreated;
//	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
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
//	public boolean getisActive() {
//		return isActive;
//	}
//	public void setisActive(boolean isActive) {
//		this.isActive = isActive;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
//	
	
}
