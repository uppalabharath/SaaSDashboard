package com.bits.saas.service;

import java.util.List;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.Enterprise;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */

public interface IEnterpriseService {

    int create(Enterprise enterprise) throws ServiceException;

    int delete(long id) throws ServiceException;

    int update(Enterprise enterprise) throws ServiceException;

    List<Enterprise> getAll() throws ServiceException;

    Enterprise getEnterprise(long id) throws ServiceException;

}
