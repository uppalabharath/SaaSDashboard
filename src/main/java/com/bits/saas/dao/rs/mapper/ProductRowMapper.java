package com.bits.saas.dao.rs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bits.saas.dao.rs.extractor.ProductRSExtractor;
import com.bits.saas.pojo.Product;

public class ProductRowMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductRSExtractor productRSExtractor = new ProductRSExtractor();
		return productRSExtractor.extractData(rs);
	}
	
}
