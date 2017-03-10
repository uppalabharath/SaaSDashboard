package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.WorkAround;

public interface IWorkAroundDao {
	
	long create(WorkAround workAround) throws DaoException;
	
	long update(WorkAround workAround) throws DaoException;
	
	long delete(long id) throws DaoException;
	
	WorkAround get(long id) throws DaoException;
	
	List<WorkAround> getAllbyRequest(long id) throws DaoException;
	
	long upvote(long id) throws DaoException;

}
