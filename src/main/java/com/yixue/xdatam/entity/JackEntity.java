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
package com.yixue.xdatam.entity;

/**
 * @author zhang
 * @date 2018年3月16日 下午11:50:36	
 */
public class JackEntity {
	public Integer id;
	public String code;
	public String subCode;
	/**
	 * code.
	 * @return  the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * subCode.
	 * @return  the subCode
	 */
	public String getSubCode() {
		return subCode;
	}
	/**
	 * @param   code  the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @param   subCode  the subCode to set
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	/**
	 * id.
	 * @return  the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param   id  the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
