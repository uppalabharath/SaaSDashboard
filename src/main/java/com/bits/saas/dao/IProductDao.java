package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.Product;

public interface IProductDao {

	long create(Product product) throws DaoException;

	int delete(long id) throws DaoException;

	int update(Product product) throws DaoException;

	Product getProduct(long id) throws DaoException;

	List<Product> getProductsByEnterpriseId(long id) throws DaoException;
	
	long updateRevenueandReputation(long id, float revenue, float reputation) throws DaoException;
}
