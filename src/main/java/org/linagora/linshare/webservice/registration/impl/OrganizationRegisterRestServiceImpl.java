package org.linagora.linshare.webservice.registration.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.jackrabbit.oak.spi.whiteboard.Registration;
import org.linagora.linshare.core.domain.constants.AccountType;
import org.linagora.linshare.core.domain.constants.ContainerQuotaType;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationRegisterDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.delegation.impl.OrganizationRegisterFacadeImpl;
import org.linagora.linshare.core.repository.hibernate.ModulesRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationAccessRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationRegisterImpl;
import org.linagora.linshare.core.repository.hibernate.OrganizationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.User1RepositoryImpl;
import org.linagora.linshare.core.utils.HashUtils;
import org.linagora.linshare.webservice.WebserviceBase;
import org.linagora.linshare.webservice.registration.OrganizationRegisterRestService;
import org.linagora.linshare.webservice.registration.RegistrationRestService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/organization")
@Api(value = "/rest/user/v2/organization", 
description = "threads service.")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class OrganizationRegisterRestServiceImpl  extends WebserviceBase implements OrganizationRegisterRestService {



	OrganizationRegisterFacadeImpl orfi;
	public OrganizationRegisterRestServiceImpl(OrganizationRegisterFacadeImpl orfi) {
		super();
		this.orfi = orfi;
	}



	@Path("/register")
	@POST
	@ApiOperation(value = "Create a registration.", response = OrganizationRegisterDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
		@ApiResponse(code = 404, message = "Thread not found."),
		@ApiResponse(code = 400, message = "Bad request : missing required fields."),
		@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public OrganizationRegisterDto create(

			@ApiParam(value = "The user domain identifier.", required = true) OrganizationRegisterDto organizationRegisterDto
			) throws BusinessException {
		// TODO Auto-generated method stub
		//		return registrationFacade.create(registration);
		System.out.println("Create Registration api" +organizationRegisterDto.getRegId() );
		System.out.println("My OrgRegDtoChecking...");
		return orfi.CreateOrganizationWithUser(organizationRegisterDto);
		//		return organizationRegisterDto;
	}

	@Path("/register1")
	@POST
	@ApiOperation(value = "Create a registration.", response = OrganizationRegisterDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
		@ApiResponse(code = 404, message = "Thread not found."),
		@ApiResponse(code = 400, message = "Bad request : missing required fields."),
		@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public String create1(

			@ApiParam(value = "The user domain identifier.", required = true) OrganizationRegisterDto organizationRegisterDto
			) throws BusinessException {
		// TODO Auto-generated method stub
		//		return registrationFacade.create(registration);
		System.out.println("Create Registration api1111:" +organizationRegisterDto.getRegId() );

		orfi.createUserActor1(organizationRegisterDto);

		return "user actor created";
		//		return organizationRegisterDto;
	}

	@Path("/register2")
	@POST
	@ApiOperation(value = "Create a registration.", response = OrganizationRegisterDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
		@ApiResponse(code = 404, message = "Thread not found."),
		@ApiResponse(code = 400, message = "Bad request : missing required fields."),
		@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public String create2(

			@ApiParam(value = "The user domain identifier.", required = true) OrganizationRegisterDto organizationRegisterDto
			) throws BusinessException {
		// TODO Auto-generated method stub
		//		return registrationFacade.create(registration);
		System.out.println("Create Registration api1111:" +organizationRegisterDto.getRegId() );

		orfi.createUserActor2(organizationRegisterDto);

		return "user actor created";
		//		return organizationRegisterDto;
	}
	
	@Path("/register2Delete")
	@DELETE
	@ApiOperation(value = "Create a registration.", response = OrganizationRegisterDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
		@ApiResponse(code = 404, message = "Thread not found."),
		@ApiResponse(code = 400, message = "Bad request : missing required fields."),
		@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public String create2Delete(

			@ApiParam(value = "The user domain identifier.", required = true) OrganizationRegisterDto organizationRegisterDto
			) throws BusinessException {
		// TODO Auto-generated method stub
		//		return registrationFacade.create(registration);
		System.out.println("My Delte check 1");
		
		return "user actor created";
		//		return organizationRegisterDto;
	}

}
