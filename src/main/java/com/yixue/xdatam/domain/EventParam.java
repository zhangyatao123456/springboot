package com.yixue.xdatam.domain;

import java.io.Serializable;

/**
 * Created by zhang on 2018/3/7.
 */
public class EventParam implements Serializable{

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 事件类型code（ASSESSMENTITEM）	是	[string]
     */
    private String sensor;

    /**
     * event发送时间	是
     */
    private String sendTime;

    /**
     * token认证	是	[string]
     */
    private String token;

    public EventParam handler(String sensor) {
        if("SESSION".equals(sensor)){

        }else if("SECTION".equals(sensor)){

        }else if("READ".equals(sensor)){

        }else if("MEDIA".equals(sensor)){
            return new MediaEventParam();
        }else if("ASSESSMENTITEM".equals(sensor)){
            return new MeasurementEventParam();
        }
        return this;
    }
}
