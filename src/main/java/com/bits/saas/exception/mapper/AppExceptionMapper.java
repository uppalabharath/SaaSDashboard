package com.bits.saas.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bits.saas.exception.AppException;
import com.bits.saas.pojo.ErrorMessage;

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {

	@Override
	public Response toResponse(AppException appEx) {

		return Response.status(appEx.getStatus())
				.entity(new ErrorMessage(appEx))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
