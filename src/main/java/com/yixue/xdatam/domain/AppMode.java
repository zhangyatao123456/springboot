package com.yixue.xdatam.domain;

import java.io.Serializable;

/**
 * Created by zhang on 2018/3/7.
 */
public class AppMode implements Serializable{
    /**
     *  appId	应用系统ID	是	[string]
     */
    private String appId;

    /**
     * appType	应用系统类型编码	是	[string]
     */
    private String appType;

    /**
     * appHost	应用系统域名	是	[string]
     */
    private String appHost;

    /**
     * appIp	应用系统IP地址	是	[string]
     */
    private String appIp;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppHost() {
		return appHost;
	}

	public void setAppHost(String appHost) {
		this.appHost = appHost;
	}

	public String getAppIp() {
		return appIp;
	}

	public void setAppIp(String appIp) {
		this.appIp = appIp;
	}
}
