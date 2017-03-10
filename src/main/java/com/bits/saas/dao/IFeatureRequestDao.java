package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.FeatureRequest;

public interface IFeatureRequestDao {

	long create(FeatureRequest request) throws DaoException;
	
	long update(FeatureRequest request) throws DaoException;
	
	long delete(long id) throws DaoException;
	
	FeatureRequest get(long id) throws DaoException;
	
	List<FeatureRequest> getRequestsByCustomer(long id) throws DaoException;
	
	List<FeatureRequest> getRequestsByProduct(long id) throws DaoException;
	
	long upvote(long id) throws DaoException;
}
