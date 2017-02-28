package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Product;
import com.bits.saas.pojo.ProductDetail;

public class ProductDetailRSExtractor implements ResultSetExtractor<ProductDetail> {

	@Override
	public ProductDetail extractData(ResultSet rs) throws SQLException, DataAccessException {
		ProductDetail productDetail = new ProductDetail();
		Product product = new Product();
		product.setId(rs.getLong(1));
		product.setName(rs.getString(2));
		productDetail.setProduct(product);
		productDetail.setBlock1(rs.getString(3));
		productDetail.setBlock2(rs.getString(4));
		productDetail.setBlock3(rs.getString(5));
		return productDetail;
	}

}
