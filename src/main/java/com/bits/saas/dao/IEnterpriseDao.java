package com.bits.saas.dao;

import java.util.List;

import com.bits.saas.exception.DaoExcpetion;
import com.bits.saas.pojo.Enterprise;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */

public interface IEnterpriseDao {

    int create(Enterprise enterprise) throws DaoExcpetion;

    int delete(long id) throws DaoExcpetion;

    int update(Enterprise enterprise) throws DaoExcpetion;

    List<Enterprise> getAll() throws DaoExcpetion;

    Enterprise getEnterprise(long id) throws DaoExcpetion;
}
