package com.yixue.xdatam.entity.sys;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-25 15:26:57
 */
public class AiKmapEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//图谱id
	private Long mid;
	//图谱编号
	private String code;
	//
	private String parentMap;
	//科目编号
	private String subCode;
	//创建时间
	private Date createTime;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    //操作人
    private String operator;
	//扩展字段1
	private String ext1;
	//扩展字段1
	private String ext2;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    //数据源（文件名）
    private String source;

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
	 * 设置：图谱编号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：图谱编号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：
	 */
	public void setParentMap(String parentMap) {
		this.parentMap = parentMap;
	}
	/**
	 * 获取：
	 */
	public String getParentMap() {
		return parentMap;
	}
	/**
	 * 设置：科目编号
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	/**
	 * 获取：科目编号
	 */
	public String getSubCode() {
		return subCode;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
	 * 设置：扩展字段1
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	/**
	 * 获取：扩展字段1
	 */
	public String getExt2() {
		return ext2;
	}


}
