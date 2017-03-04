package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.WorkAround;

public interface IWorkAroundDao {
	
	long create(WorkAround workAround) throws DaoExcpetion;
	
	long update(WorkAround workAround) throws DaoExcpetion;
	
	long delete(long id) throws DaoExcpetion;
	
	WorkAround get(long id) throws DaoExcpetion;
	
	List<WorkAround> getAllbyRequest(long id) throws DaoExcpetion;
	
	long upvote(long id) throws DaoExcpetion;

}
