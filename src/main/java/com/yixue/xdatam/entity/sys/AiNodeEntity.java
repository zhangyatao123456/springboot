package com.yixue.xdatam.entity.sys;

import java.io.Serializable;
import java.util.Date;


/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-31 17:16:23
 */
public class AiNodeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //前置id
    private Long nid;
    //图谱id
    private Long mid;
    //知识点编号
    private String code;
    //知识点的重要性1-	低频2-	中频3-	高频
    private Integer weightLevel;
    //知识点难度1-	易2-	中3-	难
    private Integer diffLevel;
    //知识点描述
    private String desc;
    //创建时间
    private Date createtime;
    //扩展字段1
    private String ext1;
    //扩展字段2
    private String ext2;
    //知识图谱编号（非数据库字段，业务拓展用）
    private String kcode;
    //知识点编号对应的直接前置知识点（非数据库字段，业务拓展用）
    private String prenodes;
    //当前操作人（非数据库字段，业务拓展用）
    private String operator;


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    /**
     * 设置：前置id
     */
    public void setNid(Long nid) {
        this.nid = nid;
    }

    /**
     * 获取：前置id
     */
    public Long getNid() {
        return nid;
    }

    /**
     * 设置：图谱id
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * 获取：图谱id
     */
    public Long getMid() {
        return mid;
    }

    /**
     * 设置：知识点编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：知识点编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：知识点的重要性1-	低频2-	中频3-	高频
     */
    public void setWeightLevel(Integer weightLevel) {
        this.weightLevel = weightLevel;
    }

    /**
     * 获取：知识点的重要性1-	低频2-	中频3-	高频
     */
    public Integer getWeightLevel() {
        return weightLevel;
    }

    /**
     * 设置：知识点难度1-	易2-	中3-	难
     */
    public void setDiffLevel(Integer diffLevel) {
        this.diffLevel = diffLevel;
    }

    /**
     * 获取：知识点难度1-	易2-	中3-	难
     */
    public Integer getDiffLevel() {
        return diffLevel;
    }

    /**
     * 设置：知识点描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取：知识点描述
     */
    public String getDesc() {
        return desc;
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

    public String getPrenodes() {
        return prenodes;
    }

    public void setPrenodes(String prenodes) {
        this.prenodes = prenodes;
    }

    public String getKcode() {
        return kcode;
    }

    public void setKcode(String kcode) {
        this.kcode = kcode;
    }


}
