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
package com.yixue.xdatam.service;

import com.yixue.xdatam.domain.EventParam;

/**
 * @author zhang
 * @date 2018年3月8日 下午1:39:45
 */

public interface MeasurementService {
	/**
	 * 添加一个测评/学习/题目类Event
	 * (日志转换-数据中心清洗数据)事件
	 * @param meParam
	 * @return
	 */
	public String insetMeasurementDom(EventParam meParam);
}
