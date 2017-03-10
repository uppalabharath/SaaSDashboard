package com.bits.saas.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.IProductDetailDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.ProductDetail;
import com.bits.saas.service.IProductDetailService;

@Service("IProductDetailService")
@Transactional
public class ProductDetailServiceImpl implements IProductDetailService {

	private static final Logger LOG = LogManager.getLogger(ProductDetailServiceImpl.class);
	@Autowired
	private IProductDetailDao productDetailDao;

	@Override
	public long create(ProductDetail productDetail) throws ServiceException {
		LOG.info("Create Product detail service");
		try {
			return productDetailDao.create(productDetail);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public long update(ProductDetail productDetail) throws ServiceException {
		LOG.info("update Product detail service");
		try {
			return productDetailDao.update(productDetail);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public ProductDetail get(long id) throws ServiceException {
		LOG.info("Retrieve Product detail service");
		try {
			return productDetailDao.get(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public long delete(long id) throws ServiceException {
		LOG.info("Delete Product detail service");
		try {
			return productDetailDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
