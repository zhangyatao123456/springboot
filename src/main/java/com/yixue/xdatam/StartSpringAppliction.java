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
package com.yixue.xdatam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.yixue.xdatam.dynamicDataSource.DynamicDataSourceRegister;

/**
 * @author zhang
 * @date 2018年3月16日 上午11:20:51
 */

@SpringBootApplication(scanBasePackages="com.yixue.xdatam")
@MapperScan("com.yixue.xdatam.dao")
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
public class StartSpringAppliction {
	public static void main(String[] args) {
		SpringApplication.run(StartSpringAppliction.class, args);
	}

}
