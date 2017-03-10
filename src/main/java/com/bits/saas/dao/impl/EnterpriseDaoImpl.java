package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IEnterpriseDao;
import com.bits.saas.dao.rs.mapper.EnterpriseRowMapper;
import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.Enterprise;
import com.bits.saas.util.query.DBQueries;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */
@Repository("IEnterpriseDao")
public class EnterpriseDaoImpl implements IEnterpriseDao {

    @Autowired private JdbcTemplate jdbcTemplate;
    private static final Logger LOG = LogManager.getLogger(IEnterpriseDao.class);

    @Override
    public int create(Enterprise enterprise) throws DaoException {
        LOG.info(enterprise.getId()+"::"+enterprise.getName());
        try {
        	return jdbcTemplate.update(DBQueries.ENTERPRISE_INSERT, new Object[] {enterprise.getName()});
        }catch (DataAccessException daEx) {
    		throw new DaoException(daEx.getMessage(),daEx);
    	}
    }

    @Override
    public int delete(long id) throws DaoException {
    	LOG.info("Delete enterprise:: "+id);
    	try {
    		return jdbcTemplate.update(DBQueries.ENTERPRISE_DELETE_BYID, new Object[] {id});
    	}catch (DataAccessException daEx) {
    		throw new DaoException(daEx.getMessage(),daEx);
    	}
    }

    @Override
    public int update(Enterprise enterprise) throws DaoException {
    	LOG.info("Update:: "+enterprise.getId()+"::"+enterprise.getName());
    	try{
    		return jdbcTemplate.update(DBQueries.ENTERPRISE_UPDATE_BYID, new Object[] {enterprise.getName(),enterprise.getId()});
    	}catch (DataAccessException daEx) {
    		throw new DaoException(daEx.getMessage(),daEx);
    	}
    }

    @Override
    public List<Enterprise> getAll() throws DaoException {
    	LOG.info("Enterprise get All in Dao");
    	try{
    		return jdbcTemplate.query(DBQueries.ENTERPRISE_SELECT_ALL, new EnterpriseRowMapper());
    	} catch (DataAccessException daEx) {
    		throw new DaoException(daEx.getMessage(),daEx);
    	}
    }

    @Override
    public Enterprise getEnterprise(long id) throws DaoException {
    	try {
    		return (Enterprise)jdbcTemplate.queryForObject(DBQueries.ENTERPRISE_SELECT_BYID, new Object[] {id}, new EnterpriseRowMapper());
    	} catch (DataAccessException daEx) {
    		throw new DaoException(daEx.getMessage(),daEx);
    	}
    }

}
