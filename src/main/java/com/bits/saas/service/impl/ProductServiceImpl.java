package com.bits.saas.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.dao.IProductDao;
import com.bits.saas.dao.IProductDetailDao;
import com.bits.saas.exception.DaoException;
import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Product;
import com.bits.saas.pojo.ProductDetail;
import com.bits.saas.service.IProductService;

@Service("IProductService")
@Transactional
public class ProductServiceImpl implements IProductService {

	private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private IProductDao productDao;
	@Autowired private IProductDetailDao productDetailDao;

	@Override
	public long create(Product product) throws ServiceException {
		LOG.info("creating product in service");
		try {
			long result = productDao.create(product);
			product.setId(result);
			ProductDetail productDetail = new ProductDetail();
			productDetail.setProduct(product);
			return productDetailDao.create(productDetail);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int delete(long id) throws ServiceException {
		LOG.info("deleting product in service");
		try {
			productDetailDao.delete(id);
			return productDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int update(Product product) throws ServiceException {
		LOG.info("updating product in service");
		try {
			return productDao.update(product);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Product getProduct(long id) throws ServiceException {
		LOG.info("get product in service");
		try {
			return productDao.getProduct(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Product> getProductsByEnterpriseId(long id) throws ServiceException {
		LOG.info("getting product enterprise id in service");
		try {
			return productDao.getProductsByEnterpriseId(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
