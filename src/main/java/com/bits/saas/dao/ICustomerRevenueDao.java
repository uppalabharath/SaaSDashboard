package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.CustomerRevenue;

public interface ICustomerRevenueDao {
	
	public long create(CustomerRevenue customerRevenue) throws DaoException;
	
	public long update(CustomerRevenue customerRevenue) throws DaoException;
	
	public long delete(CustomerRevenue customerRevenue) throws DaoException;
	
	public List<CustomerRevenue> getRevenueByProduct(long id) throws DaoException;
	
	public List<CustomerRevenue> getRevenueByCustomer(long id) throws DaoException;

	public float getAmountByCustIdMonthYear(CustomerRevenue customerRevenue) throws DaoException;
}
