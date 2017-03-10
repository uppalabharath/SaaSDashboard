package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.ICustomerRevenueDao;
import com.bits.saas.dao.rs.mapper.CustomerRevenueRowMapper;
import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.CustomerRevenue;
import com.bits.saas.util.query.DBQueries;

@Repository("ICustomerRevenueDao")
public class CustomerRevenueDaoImpl implements ICustomerRevenueDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOG = LogManager.getLogger(CustomerRevenueDaoImpl.class);

	@Override
	public long create(CustomerRevenue customerRevenue) throws DaoException {
		LOG.info("In create");
		try {
			return jdbcTemplate.update(DBQueries.REVENUE_INSERT, new Object[] { customerRevenue.getMonth(),
					customerRevenue.getYear(), customerRevenue.getCustomer().getId(), customerRevenue.getAmount() });
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(CustomerRevenue customerRevenue) throws DaoException {
		// TODO Auto-generated method stub
		LOG.info("The update operation is not supported. To achieve this perform delete adnd then insert");
		return 0;
	}

	@Override
	public long delete(CustomerRevenue customerRevenue) throws DaoException {
		LOG.info("In delete");
		try {
			return jdbcTemplate.update(DBQueries.REVENUE_DELETE_BY_CUSTID_MONTH_YEAR,new Object[] {
				customerRevenue.getCustomer().getId(),
				customerRevenue.getMonth(),
				customerRevenue.getYear()
			});
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}
	
	@Override
	public List<CustomerRevenue> getRevenueByProduct(long id) throws DaoException {
		LOG.info("In get by product id");
		try {
			return jdbcTemplate.query(DBQueries.REVENUE_GET_BYPRODID, new Object[]{id}, new CustomerRevenueRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<CustomerRevenue> getRevenueByCustomer(long id) throws DaoException {
		LOG.info("In get by customer id");
		try {
			return jdbcTemplate.query(DBQueries.REVENUE_GET_BYCUSTID, new Object[]{id},new CustomerRevenueRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

}
