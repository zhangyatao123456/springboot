package com.yixue.xdatam.entity.sys;

import java.io.Serializable;
import java.util.Date;


/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-31 17:16:23
 */
public class AiPreNodeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //前置id
    private Long preid;
    //图谱编号
    private Long mid;
    //知识点编号
    private String nodeCode;
    //前置知识点
    private String preNode;
    //创建时间
    private Date createtime;
    //扩展字段1
    private String ext1;
    //扩展字段2
    private String ext2;

    /**
     * 设置：前置id
     */
    public void setPreid(Long preid) {
        this.preid = preid;
    }

    /**
     * 获取：前置id
     */
    public Long getPreid() {
        return preid;
    }

    /**
     * 设置：图谱编号
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * 获取：图谱编号
     */
    public Long getMid() {
        return mid;
    }

    /**
     * 设置：知识点编号
     */
    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    /**
     * 获取：知识点编号
     */
    public String getNodeCode() {
        return nodeCode;
    }

    /**
     * 设置：知识点描述
     */
    public void setPreNode(String preNode) {
        this.preNode = preNode;
    }

    /**
     * 获取：知识点描述
     */
    public String getPreNode() {
        return preNode;
    }

    /**
     * 设置：创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置：扩展字段1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * 获取：扩展字段1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置：扩展字段2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    /**
     * 获取：扩展字段2
     */
    public String getExt2() {
        return ext2;
    }
}
