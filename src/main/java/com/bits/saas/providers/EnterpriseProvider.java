package com.bits.saas.providers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bits.saas.exception.AppException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Enterprise;
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.service.IEnterpriseService;

/**
 * Created by Bharath Kumar Uppala on 10/02/2017.
 */

@Path("/enterprise")
public class EnterpriseProvider {

	private static final Logger LOG = LogManager.getLogger(EnterpriseProvider.class);

	@Autowired
	private IEnterpriseService enterpriseService;

	@POST @Path("create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createEnterprise(Enterprise enterprise) throws AppException{

        LOG.info("In create enterprise");
        try{
        	int result = enterpriseService.create(enterprise);
	        if (result > 0) {
	        	return Response.status(200).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Enterprise created Successfully")).build();
	        } else {
	        	return Response.status(200).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Enterprise created failed")).build();
	        }
        } catch(ServiceException servEx) {
        	throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Enterprise create failed");
        }
        
    }

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEnterprise(@PathParam("id") Long id) throws AppException {
		LOG.info("In getting enterprise");
		try {
			Enterprise enterprise = enterpriseService.getEnterprise(id);
			return Response.ok(enterprise).build();
		} catch(ServiceException servEx){
			throw new AppException(Response.Status.NOT_FOUND.getStatusCode(),404,servEx.getMessage(),"The requested Enterprise is not found");
		}
		
	}
	
	@GET
	@Path("delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteEnterprise(@PathParam("id") Long id) throws AppException {
		LOG.info("In getting enterprise");
		try {
			int result = enterpriseService.delete(id);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Enterprise deleted Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Enterprise deleted failed")).build();
			}
		} catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Enterprise delete failed with server error");
		}
		
	}
	
	@POST @Path("update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateEnterprise(Enterprise enterprise) throws AppException{

        LOG.info("In update enterprise");
        try{
        	int result = enterpriseService.update(enterprise);
	        if (result > 0) {
	        	return Response.status(200).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Enterprise updated Successfully")).build();
	        } else {
	        	return Response.status(200).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Enterprise update failed")).build();
	        }
        } catch(ServiceException servEx) {
        	throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Enterprise update failed");
        }
        
    }
	
	@GET @Path("all")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAll() throws AppException {
		LOG.info("In getting all enterprise");
		try {
			List<Enterprise> enterpriseAll = enterpriseService.getAll();
			if (enterpriseAll == null || enterpriseAll.isEmpty()) {
				enterpriseAll = new ArrayList<Enterprise>();
			} 
			return Response.status(Response.Status.OK).entity(enterpriseAll).build();
		}catch(ServiceException servEx) {
        	throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Enterprise getting all failed");
        }
	}

}
