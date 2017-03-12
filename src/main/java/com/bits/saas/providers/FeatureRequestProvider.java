package com.bits.saas.providers;

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
import com.bits.saas.pojo.FeatureRequest;
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.service.IFeatureRequestService;

@Path("/featurerequest")
public class FeatureRequestProvider {

	private static final Logger LOG = LogManager.getLogger(FeatureRequestProvider.class);

	@Autowired
	private IFeatureRequestService requestService;

	@POST
	@Path("create")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(FeatureRequest request) throws AppException {
		LOG.info("In create");
		try {
			long result = requestService.create(request);
			if(result > 0){
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request created Successfully")).build();
			}else{
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request create failed")).build();
			}
		} catch (ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Feature Request create failed with server error");
		}
	}
	
	@POST
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response update(FeatureRequest request) throws AppException {
		LOG.info("In update");
		try {
			long result = requestService.update(request);
			if(result > 0){
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request updated Successfully")).build();
			}else{
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request update failed")).build();
			}
		} catch (ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"FeatureRequest update failed with server error");
		}
	}
	
	@GET
	@Path("freeze/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response freeze(@PathParam("id") long id) throws AppException {
		LOG.info("In freeze by request Id");
		try{
			long result = requestService.freeze(id);
			if(result > 0){
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request Freezed Successfully")).build();
			}else{
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request Freeze failed")).build();
			}
			
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Server error");
		}
	}
	
	@GET 
	@Path("all/customer/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRequestsByCustomer(@PathParam("id") long id) throws AppException {
		LOG.info("In Get by customer id");
		try{
			return Response.ok(requestService.getRequestsByCustomer(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"FeatureRequest update failed with server error");
		}
	}
	
	@GET 
	@Path("all/product/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRequestsByProduct(@PathParam("id") long id) throws AppException {
		LOG.info("In get by product Id");
		try{
			return Response.ok(requestService.getRequestsByProduct(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Server error");
		}
	}
	
	@GET 
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response get(@PathParam("id") long id) throws AppException {
		LOG.info("In get by request Id");
		try{
			return Response.ok(requestService.get(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Server error");
		}
	}
	
	@POST
	@Path("upvote")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response upvote(FeatureRequest request) throws AppException {
		LOG.info("In Upvote Feature Request");
		try{
			long result = requestService.upvote(request);
			if(result > 0){
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request upvoted Successfully")).build();
			}else{
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Feature Request upvote Successfully")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Server error");
		}
	}

}
