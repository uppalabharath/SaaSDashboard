package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.IEnterpriseDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Enterprise;
import com.bits.saas.service.IEnterpriseService;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */
@Service("IEnterpriseService")
@Transactional
public class EnterpriseServiceImpl implements IEnterpriseService {

    @Autowired private IEnterpriseDao enterpriseDao;

	private static final Logger LOG = LogManager.getLogger(IEnterpriseService.class);
    
    public EnterpriseServiceImpl() {
		super();
	}

    @Override
    public int create(Enterprise enterprise) throws ServiceException{
        LOG.info(enterprise.getId()+"::"+enterprise.getName());
        try {
			return enterpriseDao.create(enterprise);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    public int delete(long id) throws ServiceException{
        try {
			return enterpriseDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    public int update(Enterprise enterprise) throws ServiceException{
        try {
			return enterpriseDao.update(enterprise);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    public List<Enterprise> getAll() throws ServiceException{
    	LOG.info("Getting enterpriseDao::");
    	try {
			return enterpriseDao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    public Enterprise getEnterprise(long id) throws ServiceException{
        try {
			return enterpriseDao.getEnterprise(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

}
