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
import com.bits.saas.pojo.CustomerRevenue;
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.service.ICustomerRevenueService;

@Path("/revenue")
public class CustomerRevenueProvider {
	
	@Autowired private ICustomerRevenueService customerRevenueService;
	private static final Logger LOG = LogManager.getLogger(CustomerRevenueProvider.class);
	
	@POST @Path("create")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response create(CustomerRevenue customerRevenue) throws AppException {
		LOG.info("In create");
		try{
			long result = customerRevenueService.create(customerRevenue);
			if(result > 0){
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Revenue updated Successfully")).build();
			}else{
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Revenue updated Failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Revenue update failed");
		}
	}
	
	@POST @Path("update")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(CustomerRevenue customerRevenue) throws AppException {
		return null;
	}
	
	@POST @Path("delete")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response delete(CustomerRevenue customerRevenue) throws AppException {
		LOG.info("In delete");
		try{
			long result = customerRevenueService.delete(customerRevenue);
			if(result > 0){
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Revenue deleted Successfully")).build();
			}else{
				return Response.ok(new SuccessMessage(Response.Status.OK.getStatusCode(),"Revenue delete Failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Revenue delete failed");
		}
	}
	
	@GET @Path("all/product/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRevenueByProduct(@PathParam("id") long id) throws AppException {
		LOG.info("In get by product");
		try{
			return Response.ok(customerRevenueService.getRevenueByProduct(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Revenue retrieval failed");
		}
	}
	
	@GET @Path("all/customer/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRevenueByCustomer(@PathParam("id") long id) throws AppException {
		LOG.info("In get by customer");
		try{
			return Response.ok(customerRevenueService.getRevenueByCustomer(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Revenue retrieval failed");
		}
	}

}
