package com.bits.saas.dao.rs.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bits.saas.pojo.Customer;
import com.bits.saas.pojo.FeatureRequest;
import com.bits.saas.pojo.WorkAround;

public class WorkAroundRSExtractor implements ResultSetExtractor<WorkAround> {

	@Override
	public WorkAround extractData(ResultSet rs) throws SQLException, DataAccessException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
		WorkAround workAround = new WorkAround();
		workAround.setId(rs.getLong(1));
		workAround.setDescription(rs.getString(2));
		Customer customer = new Customer();
		customer.setId(rs.getLong(3));
		FeatureRequest request = new FeatureRequest();
		request.setId(rs.getLong(4));
		workAround.setUpvoteCount(rs.getInt(5));
		workAround.setCreationDate(formatter.format(rs.getTimestamp(6)));
		workAround.setModifiedDate(formatter.format(rs.getTimestamp(7)));
		request.setFreezed(rs.getBoolean(8));
		request.setSubject(rs.getString(9));
		customer.setName(rs.getString(10));
		workAround.setCustomer(customer);
		workAround.setFeatureRequest(request);
		return workAround;
	}

}
