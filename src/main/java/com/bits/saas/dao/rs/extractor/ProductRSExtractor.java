package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Enterprise;
import com.bits.saas.pojo.Product;

public class ProductRSExtractor implements ResultSetExtractor<Product> {

	@Override
	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Product product = new Product();
		product.setId(rs.getLong(1));
		product.setName(rs.getString(2));
		product.setRevenue(rs.getFloat(3));
		product.setReputation(rs.getFloat(4));
		Enterprise enterprise = new Enterprise();
		enterprise.setId(rs.getLong(5));
		enterprise.setName(rs.getString(6));
		product.setEnterprise(enterprise);
		return product;
	}

}
