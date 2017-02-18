package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.IEnterpriseDao;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Enterprise;
import com.bits.saas.service.IEnterpriseService;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */
@Service("IEnterpriseService")
public class EnterpriseServiceImpl implements IEnterpriseService {

    @Autowired private IEnterpriseDao enterpriseDao;

	private static final Logger LOG = LogManager.getLogger(IEnterpriseService.class);
    
    public EnterpriseServiceImpl() {
		super();
	}

    @Override
    @Transactional
    public int create(Enterprise enterprise) throws ServiceException{
        LOG.info(enterprise.getId()+"::"+enterprise.getName());
        try {
			return enterpriseDao.create(enterprise);
		} catch (DaoExcpetion e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    @Transactional
    public int delete(long id) throws ServiceException{
        try {
			return enterpriseDao.delete(id);
		} catch (DaoExcpetion e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    @Transactional
    public int update(Enterprise enterprise) throws ServiceException{
        try {
			return enterpriseDao.update(enterprise);
		} catch (DaoExcpetion e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    public List<Enterprise> getAll() throws ServiceException{
    	LOG.info("Getting enterpriseDao::");
    	try {
			return enterpriseDao.getAll();
		} catch (DaoExcpetion e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

    @Override
    public Enterprise getEnterprise(long id) throws ServiceException{
        try {
			return enterpriseDao.getEnterprise(id);
		} catch (DaoExcpetion e) {
			throw new ServiceException(e.getMessage(),e);
		}
    }

}
