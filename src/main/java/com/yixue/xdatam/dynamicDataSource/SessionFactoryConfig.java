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
package com.yixue.xdatam.dynamicDataSource;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * @author zhang
 * @date 2018年3月22日 下午3:45:27
 */
@Configuration
public class SessionFactoryConfig {

	/** mybatis 配置路径 */
	private static String MYBATIS_CONFIG = "mybatis-config.xml";
	 @Autowired
     private DataSource dataSource;

	/**
	 * *创建sqlSessionFactoryBean 实例 * 并且设置configtion 如驼峰命名.等等 * 设置mapper 映射路径 * 设置datasource数据源
	 * * @return
	 */
	@Bean
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		/** 设置mybatis configuration 扫描路径 */
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));

		/** 设置datasource */
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

}
