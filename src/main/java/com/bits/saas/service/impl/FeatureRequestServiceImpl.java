package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.IFeatureRequestDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.FeatureRequest;
import com.bits.saas.service.IFeatureRequestService;

@Service("IFeatureRequestService")
@Transactional
public class FeatureRequestServiceImpl implements IFeatureRequestService {

	private static final Logger LOG = LogManager.getLogger(FeatureRequestServiceImpl.class);

	@Autowired
	private IFeatureRequestDao requestDao;

	@Override
	public long create(FeatureRequest request) throws ServiceException {
		LOG.info("In create ");
		try {
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
	public long upvote(long id) throws ServiceException {
		LOG.info("In upvote");
		try {
			return requestDao.upvote(id);
		} catch (DaoException daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

}
