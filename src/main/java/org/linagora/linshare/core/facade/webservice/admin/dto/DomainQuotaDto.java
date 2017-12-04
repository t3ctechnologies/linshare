/*
 * LinShare is an open source filesharing software, part of the LinPKI software
 * suite, developed by Linagora.
 * 
 * Copyright (C) 2015 LINAGORA
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version, provided you comply with the Additional Terms applicable for
 * LinShare software by Linagora pursuant to Section 7 of the GNU Affero General
 * Public License, subsections (b), (c), and (e), pursuant to which you must
 * notably (i) retain the display of the “LinShare™” trademark/logo at the top
 * of the interface window, the display of the “You are using the Open Source
 * and free version of LinShare™, powered by Linagora © 2009–2015. Contribute to
 * Linshare R&D by subscribing to an Enterprise offer!” infobox and in the
 * e-mails sent with the Program, (ii) retain all hypertext links between
 * LinShare and linshare.org, between linagora.com and Linagora, and (iii)
 * refrain from infringing Linagora intellectual property rights over its
 * trademarks and commercial brands. Other Additional Terms apply, see
 * <http://www.linagora.com/licenses/> for more details.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License and
 * its applicable Additional Terms for LinShare along with this program. If not,
 * see <http://www.gnu.org/licenses/> for the GNU Affero General Public License
 * version 3 and <http://www.linagora.com/licenses/> for the Additional Terms
 * applicable to LinShare software.
 */
package org.linagora.linshare.core.facade.webservice.admin.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.linagora.linshare.core.domain.entities.DomainQuota;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "DomainQuota")
@ApiModel(value = "DomainQuota", description = "A domain quota instance for a domain.")
public class DomainQuotaDto extends QuotaDto {

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	@ApiModelProperty(value = "List of all quota containers.")
	List<String> containerUuids;

	protected Long currentValueForSubdomains;

	public DomainQuotaDto() {
	}

	public DomainQuotaDto(DomainQuota quota) {
		super(quota);
		this.currentValueForSubdomains = quota.getCurrentValueForSubdomains();
	}

	public List<String> getContainerUuids() {
		return containerUuids;
	}

	public void setContainerUuids(List<String> containerUuids) {
		this.containerUuids = containerUuids;
	}

	public Long getCurrentValueForSubdomains() {
		return currentValueForSubdomains;
	}

	public void setCurrentValueForSubdomains(Long currentValueForSubdomains) {
		this.currentValueForSubdomains = currentValueForSubdomains;
	}

	public void addContainerUuids(String containerUuid) {
		if (this.containerUuids == null) {
			this.containerUuids = Lists.newArrayList();
		}
		this.containerUuids.add(containerUuid);
	}

	public DomainQuota toObject() {
		DomainQuota quota = new DomainQuota();
		quota.setUuid(getUuid());
		quota.setQuota(getQuota());
		quota.setQuotaOverride(getQuotaOverride());
		quota.setDefaultQuota(getDefaultQuota());
		quota.setDefaultQuotaOverride(getDefaultQuotaOverride());
		quota.setMaintenance(getMaintenance());
		return quota;
	}

	/*
	 * Transformers
	 */
	public static Function<DomainQuota, DomainQuotaDto> toDto() {
		return new Function<DomainQuota, DomainQuotaDto>() {
			@Override
			public DomainQuotaDto apply(DomainQuota arg0) {
				return new DomainQuotaDto(arg0);
			}
		};
	}

}
