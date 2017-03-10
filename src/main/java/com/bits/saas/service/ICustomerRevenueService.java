package com.bits.saas.service;

import java.util.List;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.CustomerRevenue;

public interface ICustomerRevenueService {

	public long create(CustomerRevenue customerRevenue) throws ServiceException;

	public long update(CustomerRevenue customerRevenue) throws ServiceException;

	public long delete(CustomerRevenue customerRevenue) throws ServiceException;

	public List<CustomerRevenue> getRevenueByProduct(long id) throws ServiceException;

	public List<CustomerRevenue> getRevenueByCustomer(long id) throws ServiceException;

}
