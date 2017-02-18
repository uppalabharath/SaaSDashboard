package com.bits.saas.exception.mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bits.saas.pojo.ErrorMessage;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException notFoundEx) {
		return Response.status(Response.Status.NOT_FOUND)
				.entity(new ErrorMessage(notFoundEx))
				.build();
	}

}
