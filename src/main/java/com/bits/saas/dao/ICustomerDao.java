package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.Customer;

public interface ICustomerDao {
	
	long create(Customer customer) throws DaoException;
	
	Customer get(long id) throws DaoException;
	
	long update(Customer customer) throws DaoException;
	
	long delete(long id) throws DaoException;
	
	List<Customer> getCustomersbyProductId(long productId) throws DaoException;
	
	long updateRevenueandReputation(long id, float revenue, float reputation) throws DaoException;

}
