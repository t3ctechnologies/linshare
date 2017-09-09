package org.linagora.linshare.core.domain.entities;

import java.util.Date;

public class OrganizationAccess {
	
	private String id;
	private String moduleid;
	private String organizationid;
	private String subscriptionid;
	private Date createddate;
	private Date modifieddate;
	private boolean isdemocreated;
	private boolean isActive;
	private String statusid;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModuleid() {
		return moduleid;
	}
	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}
	
	public String getOrganizationid() {
		return organizationid;
	}
	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	public String getSubscriptionid() {
		return subscriptionid;
	}
	public void setSubscriptionid(String subscriptionid) {
		this.subscriptionid = subscriptionid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public boolean isIsdemocreated() {
		return isdemocreated;
	}
	public void setIsdemocreated(boolean isdemocreated) {
		this.isdemocreated = isdemocreated;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getStatusid() {
		return statusid;
	}
	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
