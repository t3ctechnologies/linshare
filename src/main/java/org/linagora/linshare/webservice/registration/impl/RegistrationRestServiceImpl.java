package org.linagora.linshare.webservice.registration.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.domain.objects.MailContainer;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.core.service.impl.MailNotifierServiceImpl;
import org.linagora.linshare.webservice.WebserviceBase;
import org.linagora.linshare.webservice.annotations.NoCache;
import org.linagora.linshare.webservice.registration.RegistrationRestService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
@Path("/registration")
@Api(value = "/rest/user/v2/registration", 
description = "threads service.")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class RegistrationRestServiceImpl extends WebserviceBase implements RegistrationRestService{
	
	RegistrationRepositoryImpl rri;
	MailNotifierServiceImpl notifierService;
	
	public RegistrationRestServiceImpl(RegistrationRepositoryImpl pRri) {
		this.rri = pRri;
//		this.notifierService = pNS;
	}
	

	@Path("/")
	@POST
	@ApiOperation(value = "Create a registration.", response = RegistrationDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
			@ApiResponse(code = 404, message = "Thread not found."),
			@ApiResponse(code = 400, message = "Bad request : missing required fields."),
			@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public RegistrationDto create(
			
			@ApiParam(value = "The user domain identifier.", required = true) RegistrationDto registrationDto
			) throws BusinessException {
		// TODO Auto-generated method stub
//		return registrationFacade.create(registration);
		System.out.println("Create Registration api" +registrationDto.getName() );
		RegistrationDto rdto = rri.createLogic(registrationDto);
		
		return rdto;
	}
	
	
	@Path("/{id}")
	@GET
	@ApiOperation(value = "Get a thread member.", response = RegistrationDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role.") ,
					@ApiResponse(code = 404, message = "Member not found."),
					@ApiResponse(code = 400, message = "Bad request : missing required fields."),
					@ApiResponse(code = 500, message = "Internal server error."),
					})
	@Override
	public RegistrationDto find(
			@ApiParam(value = "The user uuid.", required = true) @PathParam("id") String id)
			throws BusinessException {
		Registration reg = rri.findById(id);
		RegistrationDto rdto = new RegistrationDto(reg);
//		rdto.setDetails(reg.getName(), reg.getId());
		return rdto;
	}
	
	@Path("/")
	@PUT
	@ApiOperation(value = "Update a Registration.", response = RegistrationDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "No permission to update."),
			@ApiResponse(code = 404, message = "Guest not found."),
			@ApiResponse(code = 400, message = "Bad request : missing required fields."),  
			@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public RegistrationDto update(@ApiParam(value = "Registration to update.", required = true) RegistrationDto reg)
			throws BusinessException {
		
		
		return rri.update(reg);                                                                                                                                                                                                 
	} 
	
	@NoCache
	@Path("/findAll")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all documents.", response = RegistrationDto.class, responseContainer = "Set")
	@ApiResponses({
			@ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
			@ApiResponse(code = 404, message = "Document not found."),
			@ApiResponse(code = 400, message = "Bad request : missing required fields."),
			@ApiResponse(code = 500, message = "Internal server error."), })
	


	@Override
	public List<RegistrationDto> findAll() throws BusinessException {
		// TODO Auto-generated method stub
		return rri.findAllToDto();
	}
	
}
