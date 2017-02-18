package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Enterprise;

public class EnterpriseRSExtractor implements ResultSetExtractor<Enterprise> {

    @Override
    public Enterprise extractData(ResultSet rs) throws SQLException {
            Enterprise enterprise = new Enterprise();
            enterprise.setId(rs.getLong(1));
            enterprise.setName(rs.getString(2));
            return enterprise;
    }

}