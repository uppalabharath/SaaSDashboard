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
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.pojo.WorkAround;
import com.bits.saas.service.IWorkAroundService;

@Path("/workaround")
public class WorkAroundProvider {
	
	@Autowired private IWorkAroundService workAroundService;
	private static final Logger LOG = LogManager.getLogger(WorkAroundProvider.class);
	
	@POST
	@Path("create")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response create(WorkAround workAround) throws AppException {
		LOG.info("In Create");
		try {
			long result = workAroundService.create(workAround);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround created Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround create failed")).build();
			}
		}catch(ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Workaround create failed with server error");
		}
	}
	
	@POST
	@Path("update")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(WorkAround workAround) throws AppException {
		LOG.info("In update");
		try {
			long result = workAroundService.update(workAround);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround updated Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround update failed")).build();
			}
		}catch(ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Workaround update failed with server error");
		}
	}
	
	@GET
	@Path("delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") long id) throws AppException {
		LOG.info("In delete");
		try {
			long result = workAroundService.delete(id);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround deleted Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround delete not supported")).build();
			}
		}catch(ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Workaround delete failed with server error");
		}
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response get(@PathParam("id") long id) throws AppException {
		LOG.info("In get");
		try {
			return Response.ok(workAroundService.get(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.NOT_FOUND.getStatusCode(),404,servEx.getMessage(),"Workaround retrieval failed with server error");
		}
	}
	
	@GET
	@Path("all/request/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllbyRequest(@PathParam("id") long id) throws AppException {
		LOG.info("In getAllbyRequest");
		try {
			return Response.ok(workAroundService.getAllbyRequest(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.NOT_FOUND.getStatusCode(),404,servEx.getMessage(),"Workaround retrieval failed with server error");
		}
	}
	
	@POST
	@Path("upvote")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response upvote(WorkAround workAround) throws AppException {
		LOG.info("In upvote");
		try {
			long result = workAroundService.upvote(workAround);
			if(result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround upvoted Successfully")).build();
			}else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"WorkAround upvote failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Workaround upvote failed with server error");
		}
	}
	
}
