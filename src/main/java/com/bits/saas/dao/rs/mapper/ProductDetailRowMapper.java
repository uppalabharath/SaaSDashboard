package com.bits.saas.dao.rs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bits.saas.dao.rs.extractor.ProductDetailRSExtractor;
import com.bits.saas.pojo.ProductDetail;

public class ProductDetailRowMapper implements RowMapper<ProductDetail>{

	@Override
	public ProductDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDetailRSExtractor extractor = new ProductDetailRSExtractor();
		return extractor.extractData(rs);
	}

}
