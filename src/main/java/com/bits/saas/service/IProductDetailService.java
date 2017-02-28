package com.bits.saas.service;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.ProductDetail;

public interface IProductDetailService {
	
	long create(ProductDetail productDetail) throws ServiceException;
	
	long update(ProductDetail productDetail) throws ServiceException;
	
	ProductDetail get(long id) throws ServiceException;
	
	long delete(long id) throws ServiceException;
}
