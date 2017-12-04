/*
 * LinShare is an open source filesharing software, part of the LinPKI software
 * suite, developed by Linagora.
 * 
 * Copyright (C) 2016 LINAGORA
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
package org.linagora.linshare.mongo.entities.mto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.linagora.linshare.core.domain.entities.MailingList;
import org.linagora.linshare.core.domain.entities.MailingListContact;

import com.google.common.collect.Lists;

@XmlRootElement(name = "MailingList")
public class MailingListMto {

	protected String uuid;

	protected String name;

	protected String description;

	protected AccountMto owner;

	protected DomainMto domain;

	protected List<MailingListContactMto> contacts;

	public MailingListMto() {
	}

	public MailingListMto(MailingList list) {
		this.uuid = list.getUuid();
		this.description = list.getDescription();
		this.name = list.getIdentifier();
		this.owner = new AccountMto(list.getOwner());
		this.domain = new DomainMto(list.getDomain());
		this.contacts = Lists.newArrayList();
		for (MailingListContact m : list.getMailingListContact()) {
			contacts.add(new MailingListContactMto(m));
		}
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountMto getOwner() {
		return owner;
	}

	public void setOwner(AccountMto owner) {
		this.owner = owner;
	}

	public DomainMto getDomain() {
		return domain;
	}

	public void setDomain(DomainMto domain) {
		this.domain = domain;
	}

	public List<MailingListContactMto> getContacts() {
		return contacts;
	}

	public void setContacts(List<MailingListContactMto> contacts) {
		this.contacts = contacts;
	}
}
