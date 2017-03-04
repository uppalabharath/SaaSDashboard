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
		Product product = new Product();
		product.setName(rs.getString(5));
		customer.setProduct(product);
		return customer;
	}

}
