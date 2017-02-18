package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.Product;

public interface IProductDao {
	
int create(Product product) throws DaoExcpetion;
	
	int delete(long id) throws DaoExcpetion;
	
	int update(Product product) throws DaoExcpetion;
	
	Product getProduct(long id) throws DaoExcpetion;
	
	List<Product> getProductsByEnterpriseId(long id) throws DaoExcpetion;

}
