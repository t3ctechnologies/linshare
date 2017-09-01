package org.linagora.linshare.core.facade.webservice.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.linagora.linshare.core.domain.entities.Modules;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Modules")
//@ApiModel(value = "Registration", description = "A thread is a shared space for users to deposit files.")
public class ModulesDto  {
	
		@ApiModelProperty(value = "id")
		private String id;
		
		@ApiModelProperty(value = "Name")
		private String Name;
	
		@ApiModelProperty(value = "Description")
		private String Description;
		
		@ApiModelProperty(value = "statusId")
		private String statusId;
		
		private Date createdDate;
		private Date modifiedDate;
	
		
		public ModulesDto()
		{
			super();
		}
		
		public ModulesDto(Modules mod)
		{
			this.id = mod.getId();
			this.Name = mod.getName();
			this.Description = mod.getDescription();
			this.createdDate = mod.getCreateDate();
			this.modifiedDate = mod.getModifiedDate();

			this.statusId = mod.getStatusId();
			
		}

		public void setDetails(String id, String Name) {
			this.Name = Name;
			this.id = id;
		}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			this.Name = name;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			this.Description=description;
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

	
		public String getStatusId() {
			return statusId;
		}

		public void setStatusId(String statusId) {
			this.statusId = statusId;
		}
}
	