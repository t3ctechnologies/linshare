package org.linagora.linshare.core.domain.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.linagora.linshare.core.domain.constants.AccountPurgeStepEnum;
import org.linagora.linshare.core.domain.constants.AccountType;
import org.linagora.linshare.core.domain.constants.ContainerQuotaType;
import org.linagora.linshare.core.domain.constants.Language;
import org.linagora.linshare.core.domain.constants.Role;
import org.linagora.linshare.core.domain.constants.SupportedLanguage;

public class Account1 {
	
	
	private long id ;
	private long domain;
//	protected AbstractDomain domain;

	//	private long technical_account_permission_id;
	private Account1 owner;
	private String lsUuid;
	private String mail;
	private Date creationDate;
	private Date modificationDate;
	private int role;
	private String locale;
	private String externalMailLocale;
	private boolean enable;
	private int account_type;
	private String password;
	private long destroyed;
	private String purgeStep;
	private String cmisLocale;
	protected TechnicalAccountPermission permission;
	
	
	public TechnicalAccountPermission getPermission() {
		return permission;
	}
	public void setPermission(TechnicalAccountPermission permission) {
		this.permission = permission;
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
//	public void setDomain(AbstractDomain domain) {
//		this.domain = domain;
//	}
//	public AbstractDomain getDomain() {
//		return domain;
//	}
	
	public long getDomain() {
		return domain;
	}
	public void setDomain(long domain) {
		this.domain = domain;
	}
//	public long getTechnical_account_permission_id() {
//		return technical_account_permission_id;
//	}
//	public void setTechnical_account_permission_id(long technical_account_permission_id) {
//		this.technical_account_permission_id = technical_account_permission_id;
//	}
	public Account1 getOwner() {
		return owner;
	}
	public void setOwner(Account1 owner) {
		this.owner = owner;
	}
	public String getLsUuid() {
		return lsUuid;
	}
	public void setLsUuid(String lsUuid) {
		this.lsUuid = lsUuid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getExternalMailLocale() {
		return externalMailLocale;
	}
	public void setExternalMailLocale(String externalMailLocale) {
		this.externalMailLocale = externalMailLocale;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public int getAccount_type() {
		return account_type;
	}
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getDestroyed() {
		return destroyed;
	}
	public void setDestroyed(long destroyed) {
		this.destroyed = destroyed;
	}
	public String getPurgeStep() {
		return purgeStep;
	}
	public void setPurgeStep(String purgeStep) {
		this.purgeStep = purgeStep;
	}
	public String getCmisLocale() {
		return cmisLocale;
	}
	public void setCmisLocale(String cmisLocale) {
		this.cmisLocale = cmisLocale;
	}
	
	
	
  
	
}
