package org.linagora.linshare.core.domain.entities;

import java.util.Date;

public class OrganizationDetails {
	
	private String organizationId;
	private String addressId;
	private boolean isdemoCreated;
	private String numberofEmployee;
	private Date createdDate;
	private Date modifiedDate;
	private boolean isActive;
	private String role;
	private String id;
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public boolean isIsdemoCreated() {
		return isdemoCreated;
	}
	public void setIsdemoCreated(boolean isdemoCreated) {
		this.isdemoCreated = isdemoCreated;
	}
	public String getNumberofEmployee() {
		return numberofEmployee;
	}
	public void setNumberofEmployee(String numberofEmployee) {
		this.numberofEmployee = numberofEmployee;
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
}
