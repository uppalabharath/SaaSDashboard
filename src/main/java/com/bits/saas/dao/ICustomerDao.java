package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.Customer;

public interface ICustomerDao {
	
	public long create(Customer customer) throws DaoExcpetion;
	
	public Customer get(long id) throws DaoExcpetion;
	
	public long update(Customer customer) throws DaoExcpetion;
	
	public long delete(long id) throws DaoExcpetion;
	
	public List<Customer> getCustomersbyProductId(long productId) throws DaoExcpetion;

}
