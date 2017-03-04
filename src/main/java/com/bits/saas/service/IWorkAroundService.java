package com.bits.saas.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bits.saas.exception.ServiceException;
import com.bits.saas.pojo.WorkAround;

@Transactional
public interface IWorkAroundService {

	long create(WorkAround workAround) throws ServiceException;

	long update(WorkAround workAround) throws ServiceException;

	long delete(long id) throws ServiceException;

	WorkAround get(long id) throws ServiceException;

	List<WorkAround> getAllbyRequest(long id) throws ServiceException;

	long upvote(long id) throws ServiceException;

}
