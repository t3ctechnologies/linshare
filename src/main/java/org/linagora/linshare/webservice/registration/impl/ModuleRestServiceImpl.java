package org.linagora.linshare.webservice.registration.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.linagora.linshare.core.domain.entities.Modules;
import org.linagora.linshare.core.domain.entities.Registration;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.ModulesDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.repository.hibernate.ModulesRepositoryImpl;
import org.linagora.linshare.core.repository.hibernate.RegistrationRepositoryImpl;
import org.linagora.linshare.webservice.WebserviceBase;
import org.linagora.linshare.webservice.registration.ModulesRestService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/modules")
@Api(value = "/rest/user/v2/modules", 
description = "threads service.")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

public class ModuleRestServiceImpl extends WebserviceBase implements ModulesRestService {

	ModulesRepositoryImpl rri;
	
	public ModuleRestServiceImpl(ModulesRepositoryImpl mri) {
		this.rri = mri;
	}
	
	
	@Path("/")
	@POST
	@ApiOperation(value = "Create a modules.", response = ModulesDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
			@ApiResponse(code = 404, message = "Thread not found."),
			@ApiResponse(code = 400, message = "Bad request : missing required fields."),
			@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public ModulesDto create(
			@ApiParam(value = "The user domain identifier.", required = true) ModulesDto modulesDto
			) throws BusinessException {
		// TODO Auto-generated method stub
//		return registrationFacade.create(registration);
		System.out.println("Create Modules api" +modulesDto.getName() );
//		Registration reg = new Registration() ;
//		Date date =new Date();
//		reg.setCompanyName(registrationDto.getCompanyName());
//		reg.setCreatedDate(date);
//		reg.setEmailId(registrationDto.getEmailId());
////		reg.setEmailId("Emailid");
//		reg.setIsActive(false);
//		reg.setIsDemoCreated(true);
//		reg.setModifiedDate(date);
//		reg.setName(registrationDto.getName());
////		reg.setName("NAME");
//		reg.setPhoneNumber(registrationDto.getPhoneNumber());
////		reg.setPhoneNumber("0000000000");
//		reg.setRole("hjhjh");
//		System.out.println("is this working..."+reg.getCompanyName());
//		Registration registration = rri.create(reg);
//		System.out.println("is this working..."+registration.getId());
////		RegistrationDto rdto = new RegistrationDto();
//		RegistrationDto rdto = new RegistrationDto(registration);
////		rdto.setDetails(registration.getName(), registration.getId());
//		return rdto;
		return rri.createLogic(modulesDto);
	}

	
	@Path("/{id}")
	@GET
	@ApiOperation(value = "Get a thread member.", response = ModulesDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role.") ,
					@ApiResponse(code = 404, message = "Member not found."),
					@ApiResponse(code = 400, message = "Bad request : missing required fields."),
					@ApiResponse(code = 500, message = "Internal server error."),
					})
	@Override
	public ModulesDto find(
			@ApiParam(value = "The user uuid.", required = true) @PathParam("id") String id)
			throws BusinessException {
		Modules reg = rri.findById(id);
		ModulesDto rdto = new ModulesDto(reg);
//		rdto.setDetails(reg.getName(), reg.getId());
		return rdto;
	}

	@Path("/")
	@PUT
	@ApiOperation(value = "Update a modules.", response = ModulesDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "No permission to update."),
			@ApiResponse(code = 404, message = "Guest not found."),
			@ApiResponse(code = 400, message = "Bad request : missing required fields."),  
			@ApiResponse(code = 500, message = "Internal server error."), })
	@Override
	public ModulesDto update(@ApiParam(value = "Modules to update.", required = true) ModulesDto reg)
			throws BusinessException {
				
		System.out.println("Update Registration api" +reg.getName() );
		return rri.update(reg);                                                                                                                                                                                             
	} 

}
