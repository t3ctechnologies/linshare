package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.linagora.linshare.core.domain.entities.OrganizationDetails;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "OrganizationDetails")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")
public class OrganizationDetailsDto {
	
	@ApiModelProperty(value = "id")
	private String id;
	@ApiModelProperty(value = "organizationId")
	private String organizationId;
	
	@ApiModelProperty(value = "addressId")
	private String addressId;
	
	@ApiModelProperty(value = "numberofEmployee")
	private String numberofEmployee;
	
	@ApiModelProperty(value = "role")
	private String role;

	
	private Date createdDate;
	private Date modifiedDate;
	private boolean isdemoCreated;
	private boolean isActive;
	

	public OrganizationDetailsDto() {
		super();
	}
	
	public OrganizationDetailsDto(OrganizationDetails reg) {
		this.id = reg.getId();
		this.isActive = reg.getisActive();
		this.isdemoCreated = reg.isIsdemoCreated();
		this.modifiedDate = reg.getModifiedDate();
		this.organizationId = reg.getOrganizationId();
		this.numberofEmployee = reg.getNumberofEmployee();
		this.addressId = reg.getAddressId();
		
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
	public String getNumberofEmployee() {
		return numberofEmployee;
	}
	public void setNumberofEmployee(String numberofEmployee) {
		this.numberofEmployee = numberofEmployee;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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


}
