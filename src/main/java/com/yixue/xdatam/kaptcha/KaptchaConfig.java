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
package com.yixue.xdatam.kaptcha;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;

/**
 * @author zhang
 * @date 2018年3月20日 下午3:09:49	
 */
@Configuration
public class KaptchaConfig {
	@Bean(name = "producer")
    public Producer KaptchaProducer() {
		Properties kaptchaProperties = new Properties();
		kaptchaProperties.setProperty("kaptcha.border", "no");
		kaptchaProperties.setProperty("kaptcha.textproducer.font.color", "black");
		kaptchaProperties.setProperty("kaptcha.textproducer.char.space", "5");
		Config config = new Config(kaptchaProperties);
		return config.getProducerImpl();

	}
	


}
