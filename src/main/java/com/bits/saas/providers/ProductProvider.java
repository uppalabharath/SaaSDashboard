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
import com.bits.saas.pojo.Product;
import com.bits.saas.pojo.SuccessMessage;
import com.bits.saas.service.IProductService;

@Path("/product")
public class ProductProvider {
	
	private static final Logger LOG = LogManager.getLogger(ProductProvider.class);
	
	@Autowired private IProductService productService;
	
	@POST @Path("create")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response create(Product product) throws AppException {
		LOG.info("In Provider create product");
		try {
			int result = productService.create(product);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product created Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product create failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Enterprise delete failed with server error");
		}
	}
	
	@POST @Path("update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response update(Product product) throws AppException {
		LOG.info("In Provider update product");
		try {
			int result = productService.update(product);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product updated Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product update failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Enterprise delete failed with server error");
		}
	}
	
	@GET @Path("delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") long id) throws AppException {
		LOG.info("In Provider delete product");
		try {
			int result = productService.delete(id);
			if (result > 0) {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product deleted Successfully")).build();
			} else {
				return Response.status(Response.Status.OK).entity(new SuccessMessage(Response.Status.OK.getStatusCode(),"Product delete failed")).build();
			}
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Product delete failed with server error");
		}
	}
	
	@GET @Path("all/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllByEnterpriseId(@PathParam("id") long id) throws AppException{
		try {
			return Response.ok(productService.getProductsByEnterpriseId(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Product list retrieval failed with server error");
		}
	}
	
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response get(@PathParam("id") long id) throws AppException{
		try {
			return Response.ok(productService.getProduct(id)).build();
		}catch(ServiceException servEx){
			throw new AppException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),500,servEx.getMessage(),"Product retrieval failed with server error");
		}
	}
	
}
