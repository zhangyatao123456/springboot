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

import com.yixue.xdatam.service.MeasurementService;
import com.yixue.xdatam.domain.EventParam;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;*/

/**
 * @author zhang
 * @date 2018年3月8日 下午1:40:31	
 */
@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Resource
	private ElasticsearchTemplate esTemplate;

	/**
	 * @see com.yixue.xdatam.service.MeasurementService#insetMeasurementDom(com.yixue.xdatam.domain.MeasurementEventParam)
	 */
	@Override
	public String insetMeasurementDom(EventParam meParam) {	
		
		boolean fage = esTemplate.createIndex(meParam.getClass());
		return fage == true ? "Success":"error";
	}

}
