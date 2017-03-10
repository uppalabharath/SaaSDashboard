package com.bits.saas.dao;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.ProductDetail;

public interface IProductDetailDao {
	
	long create(ProductDetail productDetail) throws DaoException;
	
	long update(ProductDetail productDetail) throws DaoException;
	
	ProductDetail get(long id) throws DaoException;
	
	long delete(long id) throws DaoException;

}
