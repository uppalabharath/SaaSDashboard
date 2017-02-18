package com.bits.saas.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bits.saas.dao.IProductDao;
import com.bits.saas.dao.rs.mapper.ProductRowMapper;
import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.Product;
import com.bits.saas.util.query.DBQueries;

@Repository("IProductDao")
public class ProductDaoImpl implements IProductDao {

	private static final Logger LOG = LogManager.getLogger(ProductDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Product product) throws DaoExcpetion {
		LOG.info("In create product in dao");
		try {
			long productId = jdbcTemplate.queryForObject(DBQueries.PRODUCT_GET_SEQ, Long.class);
			LOG.info("Generated Id:: "+productId);
			return jdbcTemplate.update(DBQueries.PRODUCT_INSERT, new Object[] {productId, product.getName(),product.getEnterprise().getId()});
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public int delete(long id) throws DaoExcpetion {
		LOG.info("In delete product in dao");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCT_DELETE_BYID, new Object[] {id});
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public int update(Product product) throws DaoExcpetion {
		LOG.info("In update product in dao");
		try {
			return jdbcTemplate.update(DBQueries.PRODUCT_UPDATE_BYID, new Object[] {product.getName(),product.getEnterprise().getId(),product.getId()});
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public Product getProduct(long id) throws DaoExcpetion {
		LOG.info("In get product in dao");
		try {
			return jdbcTemplate.queryForObject(DBQueries.PRODUCT_SELECT_BYID, new Object[] {id}, new ProductRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

	@Override
	public List<Product> getProductsByEnterpriseId(long id) throws DaoExcpetion {
		LOG.info("In get product by enterprise id in dao");
		try {
			return jdbcTemplate.query(DBQueries.PRODUCT_SELECT_BYENTID, new Object[] {id}, new ProductRowMapper());
		} catch (DataAccessException daEx) {
			throw new DaoExcpetion(daEx.getMessage(), daEx);
		}
	}

}
