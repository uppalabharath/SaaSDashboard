package com.bits.saas.dao;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.ProductDetail;

public interface IProductDetailDao {
	
	long create(ProductDetail productDetail) throws DaoExcpetion;
	
	long update(ProductDetail productDetail) throws DaoExcpetion;
	
	ProductDetail get(long id) throws DaoExcpetion;
	
	long delete(long id) throws DaoExcpetion;

}
