package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.ICustomerDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Customer;
import com.bits.saas.service.ICustomerService;

@Service("ICustomerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired private ICustomerDao customerDao;
	
	private static final Logger LOG = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public long create(Customer customer) throws ServiceException {
		LOG.info("In create");
		try {
			return customerDao.create(customer);
		} catch(DaoException daEx) {
			throw new ServiceException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public Customer get(long id) throws ServiceException {
		LOG.info("In get");
		try {
			return customerDao.get(id);
		} catch(DaoException daEx) {
			throw new ServiceException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public long update(Customer customer) throws ServiceException {
		LOG.info("In update");
		try {
			return customerDao.update(customer);
		} catch(DaoException daEx) {
			throw new ServiceException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public long delete(long id) throws ServiceException {
		LOG.info("In delete");
		try {
			return customerDao.delete(id);
		} catch(DaoException daEx) {
			throw new ServiceException(daEx.getMessage(),daEx);
		}
	}

	@Override
	public List<Customer> getCustomersbyProductId(long productId) throws ServiceException {
		LOG.info("In getCustomersbyProductId");
		try {
			return customerDao.getCustomersbyProductId(productId);
		} catch(DaoException daEx) {
			throw new ServiceException(daEx.getMessage(),daEx);
		}
	}

}
