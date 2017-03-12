package com.bits.saas.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IProductDetailDao;
import com.bits.saas.dao.rs.mapper.ProductDetailRowMapper;
import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.ProductDetail;
import com.bits.saas.util.query.DBQueries;

@Repository("IProductDetailDao")
public class ProductDetailDaoImpl implements IProductDetailDao {

	private static final Logger LOG = LogManager.getLogger(ProductDetailDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long create(ProductDetail productDetail) throws DaoException {
		LOG.info("In create product Detail");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCT_DETAIL_INSERT, new Object[] {
					productDetail.getProduct().getId(),
					"","",""
			});
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(ProductDetail productDetail) throws DaoException {
		LOG.info("In update product Detail");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCTDETAIL_UPDATE_BYPRODID, new Object[] {
					productDetail.getBlock1(),
					productDetail.getBlock2(),
					productDetail.getBlock3(),
					productDetail.getProduct().getId()
			});
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public ProductDetail get(long id) throws DaoException {
		LOG.info("In retrieve product Detail");
		try {
			return jdbcTemplate.queryForObject(DBQueries.PRODUCTDETAIL_SELECT_BYPRODID,new Object[] {id}, new ProductDetailRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long delete(long id) throws DaoException {
		LOG.info("In delete product Detail");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCTDETAIL_DELETE_BYPRODID,new Object[] {id});
		} catch (DataAccessException daEx) {
			throw new DaoException(daEx.getMessage(), daEx);
		}
	}

}
