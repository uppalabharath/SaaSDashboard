package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.FeatureRequest;
import com.bits.saas.pojo.Product;

public class FeatureRequestRSExtractor implements ResultSetExtractor<FeatureRequest> {

	@Override
	public FeatureRequest extractData(ResultSet rs) throws SQLException, DataAccessException {
		FeatureRequest request = new FeatureRequest();
		request.setId(rs.getLong(1));
		request.setSubject(rs.getString(2));
		request.setDescription(rs.getString(3));
		request.setImpactFactor(rs.getFloat(4));
		request.setUpvoteCount(rs.getInt(5));
		request.setCreationDate(rs.getTimestamp(6));
		request.setFreezed(rs.getBoolean(7));
		Customer customer = new Customer();
		customer.setId(rs.getLong(8));
		customer.setName(rs.getString(9));
		Product product = new Product();
		product.setId(rs.getLong(10));
		product.setName(rs.getString(11));
		product.setReputation(rs.getFloat(12));
		customer.setProduct(product);
		request.setCustomer(customer);
		return request;
	}

}
