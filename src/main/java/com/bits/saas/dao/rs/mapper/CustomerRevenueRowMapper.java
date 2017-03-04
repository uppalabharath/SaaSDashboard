package com.bits.saas.dao.rs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bits.saas.dao.rs.extractor.CustomerRevenueRSExtractor;
import com.bits.saas.pojo.CustomerRevenue;

public class CustomerRevenueRowMapper implements RowMapper<CustomerRevenue> {

	@Override
	public CustomerRevenue mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CustomerRevenueRSExtractor extractor = new CustomerRevenueRSExtractor();
		return extractor.extractData(rs);
	}

}
