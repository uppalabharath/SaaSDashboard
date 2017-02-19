package com.bits.saas.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IProductDetailDao;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.ProductDetail;
import com.bits.saas.util.query.DBQueries;

@Repository("IProductDetailDao")
public class ProductDetailDaoImpl implements IProductDetailDao {

	private static final Logger LOG = LogManager.getLogger(ProductDetailDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long create(ProductDetail productDetail) throws DaoExcpetion {
		LOG.info("In create product Detail");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCT_DETAIL_INSERT, new Object[] {
					productDetail.getProduct().getId(),
					"","",""
			});
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public long update(ProductDetail productDetail) throws DaoExcpetion {
		// TODO Auto-generated method stub
		LOG.info("In update product Detail");
		try {

		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
		return 0;
	}

	@Override
	public ProductDetail get(long id) throws DaoExcpetion {
		LOG.info("In retrieve product Detail");
		try {
			//return jdbcTemplate.update(DBQueries.PRODUCTDETAIL_DELETE_BYPRODID,new Object[] {id});
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
		return null;
	}

	@Override
	public long delete(long id) throws DaoExcpetion {
		LOG.info("In delete product Detail");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCTDETAIL_DELETE_BYPRODID,new Object[] {id});
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

}
