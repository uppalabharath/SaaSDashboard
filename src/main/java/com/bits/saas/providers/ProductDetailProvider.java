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
import com.bits.saas.pojo.ProductDetail;
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.service.IProductDetailService;


@Path("/productdetail")
public class ProductDetailProvider {
	
	private static final Logger LOG = LogManager.getLogger(ProductDetailProvider.class);
	@Autowired private IProductDetailService productDetailService;
	
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response get(@PathParam("id") long id) throws AppException{
		LOG.info("In get product detail");
		try {
			return Response.ok(productDetailService.get(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Product retrieval failed with server error");
		}
	}
	
	@POST @Path("update")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(ProductDetail productDetail) throws AppException {
		LOG.info("In update product detail");
		try {
			long result = productDetailService.update(productDetail);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product details updated Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product details update failed")).build();
			}
		}catch(ServiceException servEx) {
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Product retrieval failed with server error");
		}
	}

}
