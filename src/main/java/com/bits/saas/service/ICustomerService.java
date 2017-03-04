package com.bits.saas.service;

import java.util.List;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Customer;

public interface ICustomerService {

	public long create(Customer customer) throws ServiceException;

	public Customer get(long id) throws ServiceException;

	public long update(Customer customer) throws ServiceException;

	public long delete(long id) throws ServiceException;

	public List<Customer> getCustomersbyProductId(long productId) throws ServiceException;

}
