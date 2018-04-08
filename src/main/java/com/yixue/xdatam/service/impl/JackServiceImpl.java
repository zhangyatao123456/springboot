/*
 * Copyright (C) 2016 Shanghai yixue soft Co., Ltd
 *
 * All copyrights reserved by Shanghai yixue.
 * Any copying, transferring or any other usage is prohibited.
 * Or else, Shanghai yixue possesses the right to require legal 
 * responsibilities from the violator.
 * All third-party contributions are distributed under license by
 * Shanghai yixue soft Co., Ltd.
 */
package com.yixue.xdatam.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yixue.xdatam.dao.JackDao;
import com.yixue.xdatam.dynamicDataSource.TargetDataSource;
import com.yixue.xdatam.entity.JackEntity;
import com.yixue.xdatam.service.JackService;

/**
 * @author zhang
 * @date 2018年3月16日 下午7:19:14	
 */
@Service
public class JackServiceImpl implements JackService{
	@Resource
	private JackDao jackDao;
	/**
	 * @see com.yixue.xdatam.service.JackService#updateRecordCount(java.util.Map)
	 */
	@Override
	@TargetDataSource(name = "ds1")
	public JackEntity updateRecordCount(Map param) {
		return jackDao.updateRecordCount(param);
	}
	
}
