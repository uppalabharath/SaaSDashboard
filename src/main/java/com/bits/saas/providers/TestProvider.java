package com.bits.saas.providers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bits.saas.pojo.Enterprise;

@Path("/testrs")
public class TestProvider {
	public static final Logger LOG = LogManager.getLogger(TestProvider.class);
	
	@POST
	@Path("multi")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response multiObject(Enterprise enterprise) {
		LOG.info(enterprise.getId()+enterprise.getName());
		return Response.ok(new String("Hi")).build();
	}
}
