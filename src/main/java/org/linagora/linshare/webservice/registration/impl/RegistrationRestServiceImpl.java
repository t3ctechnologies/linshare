package org.linagora.linshare.webservice.registration.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.registration.RegistrationFacade;
import org.linagora.linshare.core.facade.webservice.user.WorkGroupFacade;
import org.linagora.linshare.core.repository.AbstractRepository;
import org.linagora.linshare.core.repository.ThreadRepository;
import org.linagora.linshare.core.repository.hibernate.AbstractRegistrationImpl;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.webservice.WebserviceBase;
import org.linagora.linshare.webservice.registration.RegistrationRestService;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
@Path("/registration")
@Api(value = "/rest/registration", basePath = "/rest/", description = "threads service.", produces = "application/json,application/xml", consumes = "application/json,application/xml")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class RegistrationRestServiceImpl extends WebserviceBase implements RegistrationRestService{
	
	RegistrationRepositoryImpl rri;
	
	Registration reg = new Registration() ;
	

	@Path("/")
	@POST
	@ApiOperation(value = "Create a registration.", response = RegistrationDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
			@ApiResponse(code = 404, message = "Thread not found."),
			@ApiResponse(code = 400, message = "Bad request : missing required fields."),
			@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public RegistrationDto create(RegistrationDto registration) throws BusinessException {
		// TODO Auto-generated method stub
//		return registrationFacade.create(registration);
		System.out.println("Create Registration api");
		Date date =new Date();
		reg.setCompanyName("123");
		reg.setCreatedDate(date);
		reg.setEmailId("ghghg");
		
		reg.setIsActive(false);
		reg.setIsDemoCreated(true);
		reg.setModifiedDate(date);
		reg.setName("jhklj");
		reg.setPhoneNumber("2454541");
		reg.setRole("hjhjh");
		System.out.println("is this working..."+registration.getCompanyName());
		rri.create(reg);
		return new RegistrationDto();
	}
	
	

}
