package com.bits.saas.dao.rs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bits.saas.dao.rs.extractor.EnterpriseRSExtractor;
import com.bits.saas.pojo.Enterprise;

public class EnterpriseRowMapper implements RowMapper<Enterprise>{
	
	@Override
    public Enterprise mapRow(ResultSet rs, int line) throws SQLException {
            EnterpriseRSExtractor extractor = new EnterpriseRSExtractor();
            return extractor.extractData(rs);
    }

}
