package com.bits.saas.dao;

import com.bits.saas.exception.DaoException;

public interface IFeatureRequestDetailDao {
	
	long create(long requestId, long customerId) throws DaoException;
	
}
