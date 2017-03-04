package com.bits.saas.dao.rs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bits.saas.dao.rs.extractor.FeatureRequestRSExtractor;
import com.bits.saas.pojo.FeatureRequest;

public class FeatureRequestRowMapper implements RowMapper<FeatureRequest> {

	@Override
	public FeatureRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		FeatureRequestRSExtractor extractor = new FeatureRequestRSExtractor();
		return extractor.extractData(rs);
	}

}
