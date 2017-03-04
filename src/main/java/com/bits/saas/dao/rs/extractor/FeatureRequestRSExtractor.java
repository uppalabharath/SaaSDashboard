package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.FeatureRequest;

public class FeatureRequestRSExtractor implements ResultSetExtractor<FeatureRequest> {

	@Override
	public FeatureRequest extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
