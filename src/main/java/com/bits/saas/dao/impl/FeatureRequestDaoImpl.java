package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IFeatureRequestDao;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.FeatureRequest;

@Repository("IFeatureRequestDao")
public class FeatureRequestDaoImpl implements IFeatureRequestDao {
	
	private static final Logger LOG = LogManager.getLogger(FeatureRequestDaoImpl.class);
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@Override
	public long create(FeatureRequest request) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long update(FeatureRequest request) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long delete(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FeatureRequest get(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeatureRequest> getRequestsByCustomer(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeatureRequest> getRequestsByProduct(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long upvote(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

}
