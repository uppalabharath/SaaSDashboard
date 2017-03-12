package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.ICustomerDao;
import com.bits.saas.dao.IFeatureRequestDao;
import com.bits.saas.dao.IFeatureRequestDetailDao;
import com.bits.saas.dao.IProductDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.FeatureRequest;
import com.bits.saas.service.IFeatureRequestService;
import com.bits.saas.util.ReputationCalulationUtil;

@Service("IFeatureRequestService")
@Transactional
public class FeatureRequestServiceImpl implements IFeatureRequestService {

	private static final Logger LOG = LogManager.getLogger(FeatureRequestServiceImpl.class);

	@Autowired
	private IFeatureRequestDao requestDao;
	
	@Autowired private ICustomerDao customerDao;
	
	@Autowired private IFeatureRequestDetailDao requestDetailDao;
	
	@Autowired private IProductDao productDao;
	
	private Customer customer;

	@Override
	public long create(FeatureRequest request) throws ServiceException {
		LOG.info("In create ");
		try {
				customer = getCustomer(request.getCustomer().getId());
				request.setImpactFactor(calculateImpactFactor(customer.getReputation(), customer.getProduct().getReputation()));
				return requestDao.create(request);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(FeatureRequest request) throws ServiceException {
		LOG.info("In update ");
		try {
			return requestDao.update(request);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long delete(long id) throws ServiceException {
		LOG.info("In delete ");
		try {
			return requestDao.delete(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public FeatureRequest get(long id) throws ServiceException {
		LOG.info("In get FeatureRequest ");
		try {
			return requestDao.get(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<FeatureRequest> getRequestsByCustomer(long id) throws ServiceException {
		LOG.info("In getRequestsByCustomer ");
		try {
			return requestDao.getRequestsByCustomer(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<FeatureRequest> getRequestsByProduct(long id) throws ServiceException {
		LOG.info("in getRequestsByProduct");
		try {
			return requestDao.getRequestsByProduct(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long upvote(FeatureRequest request) throws ServiceException {
		LOG.info("In upvote");
		try {
			long result = requestDetailDao.create(request.getId(), request.getCustomer().getId());
			if(result > 0){
				float reputation = ReputationCalulationUtil.calculateReputation(getCustomer(request.getCustomer().getId()));
				FeatureRequest featureRequest = get(request.getId());
				customerDao.updateRevenueandReputation(featureRequest.getCustomer().getId(), 0, reputation);
				productDao.updateRevenueandReputation(featureRequest.getCustomer().getProduct().getId(), 0, reputation);
			}else{
				throw new ServiceException("Upvote failed. ");
			}
			return requestDao.upvote(request);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}
	
	@Override
	public long freeze(long id) throws ServiceException {
		LOG.info("In Freeze");
		try {
			return requestDao.freeze(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}
	
	private float calculateImpactFactor(float customerReputation, float productReputation) {
		LOG.info("Calculating Impact Factor while Creating request");
		//TODO Ideally should not be But Safe measure to prevent Divide by Zero
		if(productReputation == 0){
			productReputation = 1;
		}
		return customerReputation/productReputation;
	}
	
	private Customer getCustomer(long id) throws DaoException{
		return customerDao.get(id);
	}

}
