package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.CustomerRevenue;

public interface ICustomerRevenueDao {
	
	public long create(CustomerRevenue customerRevenue) throws DaoExcpetion;
	
	public long update(CustomerRevenue customerRevenue) throws DaoExcpetion;
	
	public long delete(long id) throws DaoExcpetion;
	
	public List<CustomerRevenue> getRevenueByProduct(long id) throws DaoExcpetion;
	
	public List<CustomerRevenue> getRevenueByCustomer(long id) throws DaoExcpetion;

}
