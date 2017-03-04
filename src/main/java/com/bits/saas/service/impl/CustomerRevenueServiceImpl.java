package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.saas.dao.ICustomerRevenueDao;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.CustomerRevenue;
import com.bits.saas.service.ICustomerRevenueService;

@Service("ICustomerRevenueService")
public class CustomerRevenueServiceImpl implements ICustomerRevenueService {

	@Autowired private ICustomerRevenueDao customerRevenueDao;
	
	private static final Logger LOG = LogManager.getLogger(CustomerRevenueServiceImpl.class);
	
	@Override
	public long create(CustomerRevenue customerRevenue) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long update(CustomerRevenue customerRevenue) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long delete(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerRevenue> getRevenueByProduct(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerRevenue> getRevenueByCustomer(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
