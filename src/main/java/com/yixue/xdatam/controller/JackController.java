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
package com.yixue.xdatam.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yixue.xdatam.entity.JackEntity;
import com.yixue.xdatam.service.JackService;
/**
 * @author zhang
 * @date 2018年3月16日 上午11:28:39	
 */
@Controller
public class JackController {
	 private static final Logger logger = LoggerFactory.getLogger(JackController.class);
	    
	@Resource
    private JackService jackService;
	    
//    @RequestMapping("login")
//    public @ResponseBody String login() {
//        return "ssss";
//    }
	
    @RequestMapping("mysql")
    public @ResponseBody String testMysql() {
    	System.out.println("ffffffffffffffffff");
    	JackEntity enitty = jackService.updateRecordCount(new HashMap<>());
        return "sucess";
    }
	   
	    
	   
}
