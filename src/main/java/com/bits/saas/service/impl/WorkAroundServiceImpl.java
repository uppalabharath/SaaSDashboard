package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.saas.dao.IWorkAroundDao;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.WorkAround;
import com.bits.saas.service.IWorkAroundService;

@Service("IWorkAroundService")
public class WorkAroundServiceImpl implements IWorkAroundService {

	private static final Logger LOG = LogManager.getLogger(WorkAroundServiceImpl.class);

	@Autowired
	private IWorkAroundDao workAroundDao;

	@Override
	public long create(WorkAround workAround) throws ServiceException {
		LOG.info("In create");
		try {
			return workAroundDao.create(workAround);
		} catch (DaoExcpetion daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(WorkAround workAround) throws ServiceException {
		LOG.info("In update");
		try {
			return workAroundDao.update(workAround);
		} catch (DaoExcpetion daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long delete(long id) throws ServiceException {
		LOG.info("In delete");
		try {
			return workAroundDao.delete(id);
		} catch (DaoExcpetion daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public WorkAround get(long id) throws ServiceException {
		LOG.info("In get");
		try {
			return workAroundDao.get(id);
		} catch (DaoExcpetion daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<WorkAround> getAllbyRequest(long id) throws ServiceException {
		LOG.info("In getAllbyRequest");
		try {
			return workAroundDao.getAllbyRequest(id);
		} catch (DaoExcpetion daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long upvote(long id) throws ServiceException {
		LOG.info("In upvote");
		try {
			return workAroundDao.upvote(id);
		} catch (DaoExcpetion daEx) {
			throw new ServiceException(daEx.getMessage(), daEx);
		}
	}

}
