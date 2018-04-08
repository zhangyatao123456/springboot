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
package com.yixue.xdatam.controller.irs;

import com.alibaba.fastjson.JSON;
import com.yixue.xdatam.domain.EventParam;
import com.yixue.xdatam.domain.MeasurementEventParam;
import com.yixue.xdatam.service.MeasurementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhang
 * @date 2018年3月8日 上午10:31:22
 */

@RestController
@RequestMapping("/irs")
public class EventTypeAipController  {
	
	protected Logger logger = LoggerFactory.getLogger(EventTypeAipController.class);
	
	@Autowired(required=true)
	private MeasurementService mesauService;
	
	
	@RequestMapping(value = "/eventApi", method = RequestMethod.POST)
	public @ResponseBody
    String submintEventApi(@RequestBody String eventParam) {

		System.out.println(eventParam);
		try {
			EventParam param = JSON.parseObject(eventParam, EventParam.class);
			
			if("ASSESSMENTITEM".equals(param.getSensor())) {
				param = JSON.parseObject(eventParam,MeasurementEventParam.class);
			}
			mesauService.insetMeasurementDom(param);
		}catch (Exception e) {
		
		}
		return "sessuce";
	}

	
}
