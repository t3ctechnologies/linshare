package org.linagora.linshare.webservice.registration.impl;

import java.io.Serializable;
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
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.GuestDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.WorkGroupMemberDto;
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
@Api(value = "/rest/user/v2/registration", 
description = "threads service.")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class RegistrationRestServiceImpl extends WebserviceBase implements RegistrationRestService{
	
	RegistrationRepositoryImpl rri;
	
	public RegistrationRestServiceImpl(RegistrationRepositoryImpl pRri) {
		this.rri = pRri;
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
		Registration reg = new Registration() ;
		Date date =new Date();
		reg.setCompanyName(registrationDto.getCompanyName());
//		reg.setCompanyName("CompanyName");
		reg.setCreatedDate(date);
		reg.setEmailId(registrationDto.getEmailId());
//		reg.setEmailId("Emailid");
		reg.setIsActive(false);
		reg.setIsDemoCreated(true);
		reg.setModifiedDate(date);
		reg.setName(registrationDto.getName());
//		reg.setName("NAME");
		reg.setPhoneNumber(registrationDto.getPhoneNumber());
//		reg.setPhoneNumber("0000000000");
		reg.setRole("hjhjh");
		System.out.println("is this working..."+reg.getCompanyName());
		Registration registration = rri.create(reg);
		System.out.println("is this working..."+registration.getId());
		RegistrationDto rdto = new RegistrationDto();
		rdto.setDetails(registration.getName(), registration.getId());
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
		RegistrationDto rdto = new RegistrationDto();
		rdto.setDetails(reg.getName(), reg.getId());
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
	
	

}
