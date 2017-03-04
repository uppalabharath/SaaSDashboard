package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.ICustomerRevenueDao;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.CustomerRevenue;

@Repository("ICustomerRevenueDao")
public class CustomerRevenueDaoImpl implements ICustomerRevenueDao {

	@Autowired private JdbcTemplate jdbcTemplate;
	private static final Logger LOG = LogManager.getLogger(CustomerRevenueDaoImpl.class);
	
	@Override
	public long create(CustomerRevenue customerRevenue) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long update(CustomerRevenue customerRevenue) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long delete(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerRevenue> getRevenueByProduct(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerRevenue> getRevenueByCustomer(long id) throws DaoExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

}
