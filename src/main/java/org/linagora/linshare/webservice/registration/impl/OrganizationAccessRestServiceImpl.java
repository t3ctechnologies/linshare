package org.linagora.linshare.webservice.registration.impl;
import java.io.Serializable;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.linagora.linshare.core.domain.entities.OrganizationAccess;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.common.dto.OrganizationAccessDto;
import org.linagora.linshare.core.repository.hibernate.OrganizationAccessRepositoryImpl;
import org.linagora.linshare.webservice.WebserviceBase;
import org.linagora.linshare.webservice.registration.OrganizationAccessRestService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

    @Path("/organizationaccess")
	@Api(value = "/rest/user/v2/organizationaccess", 
	description = "threads service.")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public class OrganizationAccessRestServiceImpl extends WebserviceBase implements OrganizationAccessRestService{
		
		OrganizationAccessRepositoryImpl rri;
		
		public OrganizationAccessRestServiceImpl(OrganizationAccessRepositoryImpl pRri) {
			this.rri = pRri;
		}
		

		@Path("/")
		@POST
		@ApiOperation(value = "Create a organizationaccess.", response = OrganizationAccessDto.class)
		@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role."),
				@ApiResponse(code = 404, message = "Thread not found."),
				@ApiResponse(code = 400, message = "Bad request : missing required fields."),
				@ApiResponse(code = 500, message = "Internal server error."), })
		
		@Override
		public OrganizationAccessDto create(
				
				@ApiParam(value = "The user domain identifier.", required = true) OrganizationAccessDto organizationaccessDto
				) throws BusinessException {
			// TODO Auto-generated method stub
//			return registrationFacade.create(registration);
			System.out.println("Create Organization api" +organizationaccessDto.getOrganizationId());
			return rri.createLogic(organizationaccessDto);
		}
		
		
		@Path("/{id}")
		@GET
		@ApiOperation(value = "Get a thread member.", response = OrganizationAccessDto.class)
		@ApiResponses({ @ApiResponse(code = 403, message = "Current logged in account does not have the delegation role.") ,
						@ApiResponse(code = 404, message = "Member not found."),
						@ApiResponse(code = 400, message = "Bad request : missing required fields."),
						@ApiResponse(code = 500, message = "Internal server error."),
						})
		@Override
		public OrganizationAccessDto find(
				@ApiParam(value = "The user uuid.", required = true) @PathParam("id") String id)
				throws BusinessException {
			OrganizationAccess reg = rri.findById(id);
			OrganizationAccessDto rdto = new OrganizationAccessDto(reg);
//			rdto.setDetails(reg.getName(), reg.getId());
			return rdto;
		}
		    
		@Path("/")
		@PUT
		@ApiOperation(value = "Update a Organization.", response = OrganizationAccessDto.class)
		@ApiResponses({ @ApiResponse(code = 403, message = "No permission to update."),
				@ApiResponse(code = 404, message = "Guest not found."),
				@ApiResponse(code = 400, message = "Bad request : missing required fields."),  
				@ApiResponse(code = 500, message = "Internal server error."), })
		@Override
		public OrganizationAccessDto update(
				@ApiParam(value = "Organization to update.", required = true) OrganizationAccessDto reg)
				throws BusinessException {
			
			
			return rri.update(reg);                                                                                                                                                                                                 
		}
	
}