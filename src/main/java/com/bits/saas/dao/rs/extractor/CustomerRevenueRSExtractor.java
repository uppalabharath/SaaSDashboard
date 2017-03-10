package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.CustomerRevenue;

public class CustomerRevenueRSExtractor implements ResultSetExtractor<CustomerRevenue> {
	
	@Override
	public CustomerRevenue extractData(ResultSet rs) throws SQLException, DataAccessException {
		CustomerRevenue customerRevenue = new CustomerRevenue();
		Customer customer = new Customer();
		customer.setId(rs.getLong(1));
		customerRevenue.setCustomer(customer);
		customerRevenue.setMonth(rs.getInt(2));
		customerRevenue.setYear(rs.getInt(3));
		customerRevenue.setAmount(rs.getFloat(4));
		return customerRevenue;
	}

}
