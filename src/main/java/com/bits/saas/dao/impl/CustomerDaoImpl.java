package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.ICustomerDao;
import com.bits.saas.dao.rs.mapper.CustomerRowMapper;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.Customer;
import com.bits.saas.util.query.DBQueries;

@Repository("ICustomerDao")
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOG = LogManager.getLogger(CustomerDaoImpl.class);

	@Override
	public long create(Customer customer) throws DaoExcpetion {
		LOG.info("In create");
		try {
			return jdbcTemplate.update(DBQueries.CUSTOMER_INSERT,
					new Object[] { customer.getName(), customer.getProduct().getId(), customer.getEmail() });
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public Customer get(long id) throws DaoExcpetion {
		LOG.info("In get");
		try {
			return jdbcTemplate.queryForObject(DBQueries.CUSTOMER_SELECT_BYID, new Object[] {id}, new CustomerRowMapper());
		}catch(DataAccessException daEx){
			throw new DaoExcpetion(daEx.getMessage(),daEx);
		}
	}

	@Override
	public long update(Customer customer) throws DaoExcpetion {
		LOG.info("In update");
		try {
			return jdbcTemplate.update(DBQueries.CUSTOMER_UPDATE_BYID, new Object[] {
				customer.getName(),
				customer.getProduct().getId(),
				customer.getEmail(),
				customer.getId()
			});
		}catch(DataAccessException daEx){
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long delete(long id) throws DaoExcpetion {
		LOG.info("In getCustomersbyProductId");
		try{
			return jdbcTemplate.update(DBQueries.CUSTOMER_DELETE_BYID, new Object[] {id});
		}catch(DataAccessException daEx){
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<Customer> getCustomersbyProductId(long productId) throws DaoExcpetion {
		LOG.info("In getCustomersbyProductId");
		try {
			return jdbcTemplate.query(DBQueries.CUSTOMER_SELECT_BYPRODUCTID, new Object[] {productId}, new CustomerRowMapper());
		}catch(DataAccessException daEx){
			throw new DaoExcpetion(daEx.getMessage(),daEx);
		}
	}

}
