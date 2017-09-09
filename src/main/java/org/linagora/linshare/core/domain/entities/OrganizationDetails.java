package org.linagora.linshare.core.domain.entities;

import java.util.Date;

public class OrganizationDetails {
	
	private String id;
	private String addressid;
	private String organizationid;
	private String numberofemployee;
	private Date createddate;
	private Date modifieddate;
	private boolean isdemocreated;
	private boolean isActive;
	private String statusid;        
	private String role;
	private Organization organization;
	
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getOrganizationid() {
		return organizationid;
	}
	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	public String getNumberofemployee() {
		return numberofemployee;
	}
	public void setNumberofemployee(String numberofemployee) {
		this.numberofemployee = numberofemployee;
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

}
