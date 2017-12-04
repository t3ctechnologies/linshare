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
package org.linagora.linshare.core.facade.webservice.user;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.ShareDto;
import org.linagora.linshare.core.facade.webservice.delegation.dto.ShareCreationDto;
import org.linagora.linshare.core.facade.webservice.user.dto.DocumentDto;
import org.linagora.linshare.mongo.entities.logs.AuditLogEntryUser;


public interface ShareFacade extends GenericFacade {

	public void sharedocument (String targetMail, String uuid, int securedShare) throws BusinessException;

	void multiplesharedocuments(String targetMail, List<String> uuid, int securedShare, String messageOpt, String inReplyToOpt, String referencesOpt) throws BusinessException;

	void multiplesharedocuments(List<String> mails, List<String> uuid, int securedShare, String messageOpt, String inReplyToOpt, String referencesOpt) throws BusinessException;

	void multiplesharedocuments(List<ShareDto> shares, boolean secured, String message) throws BusinessException;

	public List<ShareDto> getReceivedShares() throws BusinessException;

	public ShareDto getReceivedShare(String shareEntryUuid) throws BusinessException;

	public List<ShareDto> getShares() throws BusinessException;

	public ShareDto getShare(String shareUuid) throws BusinessException;

	public InputStream getDocumentStream(String shareEntryUuid) throws BusinessException;

	public InputStream getThumbnailStream(String shareEntryUuid) throws BusinessException;

	Set<ShareDto> create(ShareCreationDto createDto);

	ShareDto delete(String shareUuid, Boolean received) throws BusinessException;

	DocumentDto copy(String shareEntryUuid) throws BusinessException;

	Set<AuditLogEntryUser> findAll(String ownerUuid, String uuid, List<String> actions, List<String> types,
			String beginDate, String endDate);
}
