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
		try {
			long result = requestService.create(request);
		} catch (ServiceException servEx) {

		}
		return null;
	}
	
	@POST
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(FeatureRequest request) throws AppException {
		try {
			long result = requestService.update(request);
		} catch (ServiceException servEx) {

		}
		return null;
	}
	
	@GET
	@Path("delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") long id) throws AppException {
		try {
			long result = requestService.delete(id);
		} catch (ServiceException servEx) {

		}
		return null;
	}
	
	@POST 
	@Path("all/customer/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRequestsByCustomer(@PathParam("id") long id) throws AppException {
		return null;
	}
	
	@POST 
	@Path("all/product/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRequestsByProduct(@PathParam("id") long id) throws AppException {
		return null;
	}

}
