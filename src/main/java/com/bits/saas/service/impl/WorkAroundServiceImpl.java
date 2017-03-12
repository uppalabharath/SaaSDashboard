package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.ICustomerDao;
import com.bits.saas.dao.IProductDao;
import com.bits.saas.dao.IWorkAroundDao;
import com.bits.saas.dao.IWorkAroundDetailDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.WorkAround;
import com.bits.saas.service.IWorkAroundService;
import com.bits.saas.util.ReputationCalulationUtil;

@Service("IWorkAroundService")
@Transactional
public class WorkAroundServiceImpl implements IWorkAroundService {

	private static final Logger LOG = LogManager.getLogger(WorkAroundServiceImpl.class);

	@Autowired
	private IWorkAroundDao workAroundDao;
	
	@Autowired private IProductDao productDao;
	
	@Autowired private ICustomerDao customerDao;
	
	@Autowired private IWorkAroundDetailDao workAroundDetailDao;

	@Override
	public long create(WorkAround workAround) throws ServiceException {
		LOG.info("In create");
		try {
			return workAroundDao.create(workAround);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(WorkAround workAround) throws ServiceException {
		LOG.info("In update");
		try {
			return workAroundDao.update(workAround);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long delete(long id) throws ServiceException {
		LOG.info("In delete");
		try {
			return workAroundDao.delete(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public WorkAround get(long id) throws ServiceException {
		LOG.info("In get");
		try {
			return workAroundDao.get(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<WorkAround> getAllbyRequest(long id) throws ServiceException {
		LOG.info("In getAllbyRequest");
		try {
			return workAroundDao.getAllbyRequest(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long upvote(WorkAround workAround) throws ServiceException {
		LOG.info("In upvote");
		try {
			long result = workAroundDetailDao.create(workAround.getId(), workAround.getCustomer().getId());
			if(result > 0){
				float reputation = ReputationCalulationUtil.calculateReputation(getCustomer(workAround.getCustomer().getId()));
				WorkAround fetchedWorkAround = get(workAround.getId());
				Customer fetchedCustomer = getCustomer(fetchedWorkAround.getCustomer().getId());
				customerDao.updateRevenueandReputation(fetchedCustomer.getId(), 0, reputation);
				productDao.updateRevenueandReputation(fetchedCustomer.getProduct().getId(), 0, reputation);
			}else{
				throw new ServiceException("WorkAround Upvote process failed");
			}
			return workAroundDao.upvote(workAround.getId());
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}
	
	private Customer getCustomer(long id) throws DaoException{
		return customerDao.get(id);
	} 

}
