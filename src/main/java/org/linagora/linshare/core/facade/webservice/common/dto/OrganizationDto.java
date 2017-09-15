package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.linagora.linshare.core.domain.entities.Organization;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Organization")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")

public class OrganizationDto {

	
		@ApiModelProperty(value = "id")
		private String id;
		
		@ApiModelProperty(value = "name")
		private String name;
		

		@ApiModelProperty(value = "companyName")
		private String companyName;
		
		@ApiModelProperty(value = "location")
		private String location;
	
		@ApiModelProperty(value = "longitude")
		private String longitude;
		
		@ApiModelProperty(value = "latitude")
		private String latitude;
		
//		@ApiModelProperty(value = "role")
//		private String role;
//		
		private Date createdDate;
		private Date modifiedDate;
		private boolean isDemoCreated;
		private boolean isActive;
		private String registrationId;
//		private String role;
		
		
		public OrganizationDto() {
			super();
		}
		
		public String getRegistrationId() {
			return registrationId;
		}

		public void setRegistrationId(String registrationId) {
			this.registrationId = registrationId;
		}

		public OrganizationDto(Organization reg) {
			this.id = reg.getId();
			this.companyName = reg.getCompanyName();
			this.name = reg.getName();
			this.location = reg.getLocation();
			this.longitude = reg.getLongitude();
			this.latitude = reg.getLatitude();
			this.createdDate = reg.getCreatedDate();
			this.modifiedDate = reg.getModifiedDate();
			
		    
		}
		
		public void setDetails(String name, String id) {
			this.name = name;
			this.id = id;
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
			System.out.println("Organization setName "+name);
			this.name = name;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			System.out.println("Organization setLatitude "+latitude);
			this.latitude = latitude;
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
			System.out.println("Organization Modified Date ");
			this.modifiedDate = modifiedDate;
		}

		public boolean isDemoCreated() {
			return isDemoCreated;
		}

		public void setDemoCreated(boolean isDemoCreated) {
			this.isDemoCreated = isDemoCreated;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

//		public String getRole() {
//			return role;
//		}
//
//		public void setRole(String role) {
//			this.role = role;
//		}
		
		
	
		
}


