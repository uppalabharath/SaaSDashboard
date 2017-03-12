package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IFeatureRequestDao;
import com.bits.saas.dao.rs.mapper.FeatureRequestRowMapper;
import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.FeatureRequest;
import com.bits.saas.util.query.DBQueries;

@Repository("IFeatureRequestDao")
public class FeatureRequestDaoImpl implements IFeatureRequestDao {
	
	private static final Logger LOG = LogManager.getLogger(FeatureRequestDaoImpl.class);
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@Override
	public long create(FeatureRequest request) throws DaoException {
		LOG.info("In Create");
		try{
			return jdbcTemplate.update(DBQueries.FEATUREREQUEST_INSERT, new Object[] {
				request.getSubject(),
				request.getDescription(),
				request.getImpactFactor(),
				request.getCustomer().getId()
			});
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public long update(FeatureRequest request) throws DaoException {
		LOG.info("In Update");
		try{
			return jdbcTemplate.update(DBQueries.FEATUREREQUEST_UPDATE_BYID, new Object[]{
					request.getCustomer().getId(),
					request.getId()
			});
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public long delete(long id) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FeatureRequest get(long id) throws DaoException {
		LOG.info("In Get by request id");
		try{
			return jdbcTemplate.queryForObject(DBQueries.FEATUREREQUEST_SELECT_BYID, new Object[]{id}, new FeatureRequestRowMapper());
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public List<FeatureRequest> getRequestsByCustomer(long id) throws DaoException {
		LOG.info("In Get by customer id");
		try{
			return jdbcTemplate.query(DBQueries.FEATUREREQUEST_SELECT_BYCUSTID, new Object[]{id}, new FeatureRequestRowMapper());
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public List<FeatureRequest> getRequestsByProduct(long id) throws DaoException {
		LOG.info("In Get by product id");
		try{
			return jdbcTemplate.query(DBQueries.FEATUREREQUEST_SELECT_BYPRODID, new Object[]{id}, new FeatureRequestRowMapper());
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public long freeze(long id) throws DaoException {
		LOG.info("In Freeze");
		try{
			return jdbcTemplate.update(DBQueries.FEATUREREQUEST_UPDATE_FREEZE_BYID, new Object[]{id});
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}
	
	@Override
	public long upvote(FeatureRequest request) throws DaoException {
		LOG.info("In Upvote");
		try{
			return jdbcTemplate.update(DBQueries.FEATUREREQUEST_UPDATE_UPVOTE_IMPACT_BYID,new Object[]{
					request.getId(),
					request.getImpactFactor(),
					1
			});
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

}
