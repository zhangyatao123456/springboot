package com.yixue.xdatam.domain;

import java.io.Serializable;

/**
 * Created by zhang on 2018/3/7.
 */
public class MeasurementAction implements Serializable{

    /**
     * itemId	知识点ID	是	[string]
     */
    private String itemId;

    /**
     * itemType	知识点类型	是	[string]
     */
    private String itemType;

    /**
     *  startTime	做题开始时间	是	[string]
     */
    private String startTime;

    /**
     * endTime	做题结束时间	是	[string]
     */
    private String endTime;

    /**
     * duration	做题时长（单位为秒）	是	[string]
     */
    private String duration;

    /**
     * result	做题结果	是	[string
     */
    private String result;

    /**
     * stuAnswer	学生作答填写的答案	是	[string]
     */
    private String stuAnswer;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStuAnswer() {
		return stuAnswer;
	}

	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
	}
}
