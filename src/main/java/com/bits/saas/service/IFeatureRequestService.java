package com.bits.saas.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.FeatureRequest;

@Transactional
public interface IFeatureRequestService {
	
	long create(FeatureRequest request) throws ServiceException;
	
	long update(FeatureRequest request) throws ServiceException;
	
	long delete(long id) throws ServiceException;
	
	FeatureRequest get(long id) throws ServiceException;
	
	List<FeatureRequest> getRequestsByCustomer(long id) throws ServiceException;
	
	List<FeatureRequest> getRequestsByProduct(long id) throws ServiceException;
	
	long upvote(long id) throws ServiceException;

}
