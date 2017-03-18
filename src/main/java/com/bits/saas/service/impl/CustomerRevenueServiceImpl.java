package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.ICustomerDao;
import com.bits.saas.dao.ICustomerRevenueDao;
import com.bits.saas.dao.IProductDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.CustomerRevenue;
import com.bits.saas.service.ICustomerRevenueService;

@Service("ICustomerRevenueService")
@Transactional
public class CustomerRevenueServiceImpl implements ICustomerRevenueService {

	@Autowired private ICustomerRevenueDao customerRevenueDao;
	
	@Autowired private IProductDao productDao;
	
	@Autowired private ICustomerDao customerDao;
	
	private static final Logger LOG = LogManager.getLogger(CustomerRevenueServiceImpl.class);
	
	@Override
	public long create(CustomerRevenue customerRevenue) throws ServiceException {
		LOG.info("In create");
		try{
			long result = customerRevenueDao.create(customerRevenue);
			if(result > 0){
				Customer customer = customerDao.get(customerRevenue.getCustomer().getId());
				customerDao.updateRevenueandReputation(customer.getId(), customerRevenue.getAmount(), customerRevenue.getAmount());
				return productDao.updateRevenueandReputation(customer.getProduct().getId(), customerRevenue.getAmount(), customerRevenue.getAmount());
			}else{
				throw new ServiceException("Insertion to customer revenue failed. ");
			}
			
		}catch(DaoException daoEx){
			throw new ServiceException(daoEx.getMessage(),daoEx);
		}
	}

	@Override
	public long update(CustomerRevenue customerRevenue) throws ServiceException {
		LOG.info("Update not supported");
		return 0;
	}

	@Override
	public long delete(CustomerRevenue customerRevenue) throws ServiceException {
		LOG.info("In delete");
		try{
			float amount = customerRevenueDao.getAmountByCustIdMonthYear(customerRevenue);
			long result = customerRevenueDao.delete(customerRevenue);
			if(result > 0){
				Customer customer = customerDao.get(customerRevenue.getCustomer().getId());
				customerDao.updateRevenueandReputation(customer.getId(), 0 - amount, 0 - amount);
				return productDao.updateRevenueandReputation(customer.getProduct().getId(), 0 - amount, 0 - amount);
			}else{
				throw new ServiceException("Deletion of customer revenue failed. ");
			}
		}catch(DaoException daoEx){
			throw new ServiceException(daoEx.getMessage(),daoEx);
		}
	}

	@Override
	public List<CustomerRevenue> getRevenueByProduct(long id) throws ServiceException {
		LOG.info("In get revenue by product");
		try{
			return customerRevenueDao.getRevenueByProduct(id);
		}catch(DaoException daoEx){
			throw new ServiceException(daoEx.getMessage(),daoEx);
		}
	}

	@Override
	public List<CustomerRevenue> getRevenueByCustomer(long id) throws ServiceException {
		LOG.info("In get getRevenueByCustomer");
		try{
			return customerRevenueDao.getRevenueByCustomer(id);
		}catch(DaoException daoEx){
			throw new ServiceException(daoEx.getMessage(),daoEx);
		}
	}

}
