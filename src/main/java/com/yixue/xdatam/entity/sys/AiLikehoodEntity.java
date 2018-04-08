package com.yixue.xdatam.entity.sys;

import java.io.Serializable;
import java.util.Date;


/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-07-13 17:04:05
 */
public class AiLikehoodEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //会话编号
    private Long sessionId;
    //图谱编号
    private String mcode;
    //知识点编号
    private String ncode;
    //概率数据
    private String likehood;
    //创建时间
    private Date ctime;
    //更新时间
    private Date utime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：会话编号
     */
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取：会话编号
     */
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * 设置：图谱编号
     */
    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    /**
     * 获取：图谱编号
     */
    public String getMcode() {
        return mcode;
    }

    /**
     * 设置：知识点编号
     */
    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    /**
     * 获取：知识点编号
     */
    public String getNcode() {
        return ncode;
    }

    /**
     * 设置：概率数据
     */
    public void setLikehood(String likehood) {
        this.likehood = likehood;
    }

    /**
     * 获取：概率数据
     */
    public String getLikehood() {
        return likehood;
    }

    /**
     * 设置：创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置：更新时间
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUtime() {
        return utime;
    }
}
