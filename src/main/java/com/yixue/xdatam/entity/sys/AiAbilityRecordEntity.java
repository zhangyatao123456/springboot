package com.yixue.xdatam.entity.sys;

import java.io.Serializable;
import java.util.Date;


/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-06-24 15:10:12
 */
public class AiAbilityRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //记录编号
    private Long rid;
    //图谱编号
    private String tcode;
    //知识点编号
    private String ncode;
    //学生编号
    private String stuid;
    //能力值
    private String ability;
    //能力评估信心值
    private String abilityProp;
    //概率值集合
    private String likelihood;
    //课次编号
    private String curriculumId;
    //创建时间
    private Date createtime;
    //题目数量
    private Long qnum;
    //系统编号
    private String sysCode;
    //流程编号
    private Long sessionId;
    //过程阶段编码
    private String stage;
    //扩展字段1
    private String ext1;
    //扩展字段2
    private String ext2;
    //扩展字段3
    private String ext3;

    /**
     * 设置：记录编号
     */
    public void setRid(Long rid) {
        this.rid = rid;
    }

    /**
     * 获取：记录编号
     */
    public Long getRid() {
        return rid;
    }

    /**
     * 设置：图谱编号
     */
    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    /**
     * 获取：图谱编号
     */
    public String getTcode() {
        return tcode;
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
     * 设置：学生编号
     */
    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    /**
     * 获取：学生编号
     */
    public String getStuid() {
        return stuid;
    }

    /**
     * 设置：能力值
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }

    /**
     * 获取：能力值
     */
    public String getAbility() {
        return ability;
    }

    /**
     * 设置：能力评估信心值
     */
    public void setAbilityProp(String abilityProp) {
        this.abilityProp = abilityProp;
    }

    /**
     * 获取：能力评估信心值
     */
    public String getAbilityProp() {
        return abilityProp;
    }

    /**
     * 设置：概率值集合
     */
    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }

    /**
     * 获取：概率值集合
     */
    public String getLikelihood() {
        return likelihood;
    }

    /**
     * 设置：课次编号
     */
    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    /**
     * 获取：课次编号
     */
    public String getCurriculumId() {
        return curriculumId;
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
     * 设置：题目数量
     */
    public void setQnum(Long qnum) {
        this.qnum = qnum;
    }

    /**
     * 获取：题目数量
     */
    public Long getQnum() {
        return qnum;
    }

    /**
     * 设置：系统编号
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * 获取：系统编号
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * 设置：流程编号
     */
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取：流程编号
     */
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * 设置：过程阶段编码
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * 获取：过程阶段编码
     */
    public String getStage() {
        return stage;
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

    /**
     * 设置：扩展字段3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    /**
     * 获取：扩展字段3
     */
    public String getExt3() {
        return ext3;
    }
}
