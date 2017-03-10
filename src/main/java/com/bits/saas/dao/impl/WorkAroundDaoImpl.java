package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IWorkAroundDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.WorkAround;

@Repository("IWorkAroundDao")
public class WorkAroundDaoImpl implements IWorkAroundDao {

	@Autowired private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOG = LogManager.getLogger(WorkAroundDaoImpl.class);
	
	@Override
	public long create(WorkAround workAround) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long update(WorkAround workAround) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long delete(long id) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WorkAround get(long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkAround> getAllbyRequest(long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long upvote(long id) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

}
