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
import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.service.ICustomerService;

@Path("/customer")
public class CustomerProvider {

	@Autowired
	private ICustomerService customerService;

	private static final Logger LOG = LogManager.getLogger(CustomerProvider.class);

	@POST
	@Path("create")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Customer customer) throws AppException {
		try {
			long result = customerService.create(customer);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Customer created Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Customer create failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Product delete failed with server error");
		}
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get(@PathParam("id") long id) throws AppException {
		try {
			return Response.ok(customerService.get(id)).build();
		} catch (ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 500, servEx.getMessage(),
					"Customer retrieval failed with server error");
		}
	}

	@POST
	@Path("update")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Customer customer) throws AppException {
		try {
			long result = customerService.update(customer);
			if (result > 0) {
				return Response.status(Response.Status.OK)
						.entity(new SuccessMessage(Response.Status.OK.getStatusCode(), "Customer updated Successfully"))
						.build();
			} else {
				return Response.status(Response.Status.OK)
						.entity(new SuccessMessage(Response.Status.OK.getStatusCode(), "Customer update failed"))
						.build();
			}
		} catch (ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 500, servEx.getMessage(),
					"Product delete failed with server error");
		}
	}

	@GET
	@Path("delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") long id) throws AppException {
		LOG.info("In delete");
		try {
			long result = customerService.delete(id);
			if (result > 0) {
				return Response.status(Response.Status.OK)
						.entity(new SuccessMessage(Response.Status.OK.getStatusCode(), "Customer deleted Successfully"))
						.build();
			} else {
				return Response.status(Response.Status.OK)
						.entity(new SuccessMessage(Response.Status.OK.getStatusCode(), "Customer delete failed"))
						.build();
			}
		} catch (ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 500, servEx.getMessage(),
					"Product delete failed with server error");
		}
	}

	@GET
	@Path("all/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllByProductId(@PathParam("id") long id) throws AppException {
		try {
			return Response.ok(customerService.getCustomersbyProductId(id)).build();
		} catch (ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 500, servEx.getMessage(),
					"Customer retrieval failed with server error");
		}
	}

}
