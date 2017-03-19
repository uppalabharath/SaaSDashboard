package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IWorkAroundDao;
import com.bits.saas.dao.rs.mapper.WorkAroundRowMapper;
import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.WorkAround;
import com.bits.saas.util.query.DBQueries;

@Repository("IWorkAroundDao")
public class WorkAroundDaoImpl implements IWorkAroundDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOG = LogManager.getLogger(WorkAroundDaoImpl.class);

	@Override
	public long create(WorkAround workAround) throws DaoException {
		LOG.info("In Create");
		try {
			long workAroundId = jdbcTemplate.queryForObject(DBQueries.WORKAROUND_GET_SEQ, Long.class);
			long result = jdbcTemplate.update(DBQueries.WORKAROUND_INSERT, new Object[]{
					workAroundId,
					workAround.getDescription(),
					workAround.getCustomer().getId(),
					workAround.getFeatureRequest().getId()
			});
			if(result > 0) {
				return workAroundId;
			}
			return result;
			
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(WorkAround workAround) throws DaoException {
		LOG.info("In Update");
		try {
			return jdbcTemplate.update(DBQueries.WORKAROUND_UPDATE_BYID, new Object[]{
					workAround.getDescription(),
					workAround.getId(),
					workAround.getCustomer().getId()
			});
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long delete(long id) throws DaoException {
		LOG.info("In Delete Operation not valid");
		return 0;
	}

	@Override
	public WorkAround get(long id) throws DaoException {
		LOG.info("In Get by WorkAround id");
		try {
			return jdbcTemplate.queryForObject(DBQueries.WORKAROUND_SELECT_BYID, new Object[]{id},new WorkAroundRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<WorkAround> getAllbyRequest(long id) throws DaoException {
		LOG.info("In Get WorkAround by Request Ids");
		try {
			return jdbcTemplate.query(DBQueries.WORKAROUND_SELECT_BYREQID, new Object[]{id},new WorkAroundRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long upvote(long id) throws DaoException {
		LOG.info("In Upvote");
		try {
			return jdbcTemplate.update(DBQueries.WORKAROUND_UPDATE_UPVOTE_BYID, new Object[]{id,1,id});
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

}
