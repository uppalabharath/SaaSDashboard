package com.bits.saas.service;

import java.util.List;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Product;

public interface IProductService {
	
	long create(Product product) throws ServiceException;
	
	int delete(long id) throws ServiceException;
	
	int update(Product product) throws ServiceException;
	
	Product getProduct(long id) throws ServiceException;
	
	List<Product> getProductsByEnterpriseId( long id) throws ServiceException;

}
