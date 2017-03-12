package com.bits.saas.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IWorkAroundDetailDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.util.query.DBQueries;

@Repository("IWorkAroundDetailDao")
public class WorkAroundDetailDaoImpl implements IWorkAroundDetailDao {
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOG = LogManager.getLogger(WorkAroundDetailDaoImpl.class);

	@Override
	public long create(long workAroundId, long customerId) throws DaoException {
		LOG.info("In create");
		try{
			return jdbcTemplate.update(DBQueries.WORKAROUND_DETAIL_INSERT,new Object[]{workAroundId, customerId});
		}catch(DataAccessException daEx){
			throw new DaoException(daEx.getMessage(),daEx);
		}
	}

}
