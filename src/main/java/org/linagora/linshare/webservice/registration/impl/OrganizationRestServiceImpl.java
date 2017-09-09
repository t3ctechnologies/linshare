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

import org.linagora.linshare.core.domain.entities.Organization;
import org.linagora.linshare.core.exception.BusinessException;
	import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationDto;
import org.linagora.linshare.core.facade.webservice.common.dto.RegistrationDto;
	import org.linagora.linshare.core.repository.hibernate.OrganizationRepositoryImpl;
import org.linagora.linshare.webservice.WebserviceBase;
import org.linagora.linshare.webservice.registration.OrganizationRestService;
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
	public class OrganizationRestServiceImpl extends WebserviceBase implements OrganizationRestService{
		
		OrganizationRepositoryImpl rri;
		
		public OrganizationRestServiceImpl(OrganizationRepositoryImpl pRri) {
			this.rri = pRri;
		}
		

		@Path("/")
		@POST
		@ApiOperation(value = "Create a organization.", response = OrganizationDto.class)
		@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
				@ApiResponse(code = 404, message = "Thread not found."),
				@ApiResponse(code = 400, message = "Bad request : missing required fields."),
				@ApiResponse(code = 500, message = "Internal server error."), })
		
		@Override
		public OrganizationDto create(
				
				@ApiParam(value = "The user domain identifier.", required = true) OrganizationDto organizationDto
				) throws BusinessException {
			// TODO Auto-generated method stub
//			return registrationFacade.create(registration);
			System.out.println("Create Organization api" +organizationDto.getName() );
			return rri.createLogic(organizationDto);
		}
		
		
		@Path("/{id}")
		@GET
		@ApiOperation(value = "Get a thread member.", response = OrganizationDto.class)
		@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role.") ,
						@ApiResponse(code = 404, message = "Member not found."),
						@ApiResponse(code = 400, message = "Bad request : missing required fields."),
						@ApiResponse(code = 500, message = "Internal server error."),
						})
		@Override
		public OrganizationDto find(
				@ApiParam(value = "The user uuid.", required = true) @PathParam("id") String id)
				throws BusinessException {
			Organization reg = rri.findById(id);
			OrganizationDto rdto = new OrganizationDto(reg);
//			rdto.setDetails(reg.getName(), reg.getId());
			return rdto;
		}
		    
		@Path("/")
		@PUT
		@ApiOperation(value = "Update a Organization.", response = OrganizationDto.class)
		@ApiResponses({ @ApiResponse(code = 403, message = "No permission to update."),
				@ApiResponse(code = 404, message = "Guest not found."),
				@ApiResponse(code = 400, message = "Bad request : missing required fields."),  
				@ApiResponse(code = 500, message = "Internal server error."), })
		@Override
		public OrganizationDto update(@ApiParam(value = "Organization to update.", required = true) OrganizationDto reg)
				throws BusinessException {
			
			
			return rri.update(reg);                                                                                                                                                                                                 
		}


	

	
}