package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.FeatureRequest;

public interface IFeatureRequestDao {

	long create(FeatureRequest request) throws DaoExcpetion;
	
	long update(FeatureRequest request) throws DaoExcpetion;
	
	long delete(long id) throws DaoExcpetion;
	
	FeatureRequest get(long id) throws DaoExcpetion;
	
	List<FeatureRequest> getRequestsByCustomer(long id) throws DaoExcpetion;
	
	List<FeatureRequest> getRequestsByProduct(long id) throws DaoExcpetion;
	
	long upvote(long id) throws DaoExcpetion;
}
