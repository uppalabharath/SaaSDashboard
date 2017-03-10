package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoException;
import com.bits.saas.pojo.Enterprise;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */

public interface IEnterpriseDao {

    int create(Enterprise enterprise) throws DaoException;

    int delete(long id) throws DaoException;

    int update(Enterprise enterprise) throws DaoException;

    List<Enterprise> getAll() throws DaoException;

    Enterprise getEnterprise(long id) throws DaoException;
}
