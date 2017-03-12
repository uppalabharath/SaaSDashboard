package com.bits.saas.dao;

import com.bits.saas.exception.DaoException;

public interface IWorkAroundDetailDao {
	
	long create(long workAroundId, long customerId) throws DaoException;

}
