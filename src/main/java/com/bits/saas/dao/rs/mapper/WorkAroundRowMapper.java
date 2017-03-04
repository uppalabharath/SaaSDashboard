package com.bits.saas.dao.rs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bits.saas.dao.rs.extractor.WorkAroundRSExtractor;
import com.bits.saas.pojo.WorkAround;

public class WorkAroundRowMapper implements RowMapper<WorkAround> {

	@Override
	public WorkAround mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkAroundRSExtractor extractor = new WorkAroundRSExtractor();
		return extractor.extractData(rs);
	}

}
