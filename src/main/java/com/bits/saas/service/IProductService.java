package com.bits.saas.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Product;

public interface IProductService {
	
	@Transactional
	long create(Product product) throws ServiceException;
	
	@Transactional
	int delete(long id) throws ServiceException;
	
	@Transactional
	int update(Product product) throws ServiceException;
	
	Product getProduct(long id) throws ServiceException;
	
	List<Product> getProductsByEnterpriseId( long id) throws ServiceException;

}
