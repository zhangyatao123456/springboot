package com.yixue.xdatam.domain;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by zhang on 2018/3/7.
 */
@Document(indexName="measurementevent",type="measurementevent",shards=6,replicas=2)
public class MeasurementEventParam extends EventParam {

    /**
     *    actor	用户uuid(reg_id) 必须
     */
    private  String actor;

    /**
     *    action	行为类型编码 必须
     STARTED 开始
     SKIPPED 跳过
     SUBMITTED 提交
     */
    private String action;

    /**
     * action动作属性的分装
     */
    private MeasurementAction measurementAction;

    /**
     * 事件发生时间	是	[string]
     */
    private String eventTime;

    /**
     * 时间发生系统平台	是
     */
    private AppMode appMode;

    /**
     * 学习会话（sessionId）	是	[string]
     */
    private String federatedSession;

    /**
     * 是	[string]
     */
    private String groupId;

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public MeasurementAction getMeasurementAction() {
		return measurementAction;
	}

	public void setMeasurementAction(MeasurementAction measurementAction) {
		this.measurementAction = measurementAction;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public AppMode getAppMode() {
		return appMode;
	}

	public void setAppMode(AppMode appMode) {
		this.appMode = appMode;
	}

	public String getFederatedSession() {
		return federatedSession;
	}

	public void setFederatedSession(String federatedSession) {
		this.federatedSession = federatedSession;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


}
