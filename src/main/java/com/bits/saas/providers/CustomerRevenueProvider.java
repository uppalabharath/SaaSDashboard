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
import com.bits.saas.pojo.CustomerRevenue;
import com.bits.saas.service.ICustomerRevenueService;

@Path("/revenue")
public class CustomerRevenueProvider {
	
	@Autowired private ICustomerRevenueService customerRevenueService;
	private static final Logger LOG = LogManager.getLogger(CustomerRevenueProvider.class);
	
	@POST @Path("create")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response create(CustomerRevenue customerRevenue) throws AppException {
		return null;
	}
	
	@POST @Path("update")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(CustomerRevenue customerRevenue) throws AppException {
		return null;
	}
	
	@GET @Path("delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") long id) throws AppException {
		return null;
	}
	
	@GET @Path("all/product/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRevenueByProduct(@PathParam("id") long id) throws AppException {
		return null;
	}
	
	@GET @Path("all/customer/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRevenueByCustomer(@PathParam("id") long id) throws AppException {
		return null;
	}

}
