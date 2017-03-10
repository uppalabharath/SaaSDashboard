package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.Product;

public class CustomerRSExtractor implements ResultSetExtractor<Customer> {

	@Override
	public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
		Customer customer = new Customer();
		customer.setId(rs.getLong(1));
		customer.setName(rs.getString(2));
		customer.setEmail(rs.getString(3));
		customer.setReputation(rs.getFloat(4));
		customer.setRevenue(rs.getFloat(5));
		Product product = new Product();
		product.setId(rs.getLong(6));
		product.setName(rs.getString(7));
		customer.setProduct(product);
		return customer;
	}

}
