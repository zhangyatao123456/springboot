package com.yixue.xdatam.domain;

/**
 * Created by zhang on 2018/3/7.
 */
public class MediaEventParam extends EventParam{
    /**
     *    actor	用户uuid(reg_id) 必须
     */
    private  String actor;


    /**
     *    action	行为类型编码 必须
     OPENED_POPOUT 弹出视频
     CLOSED_POPOUT 关闭视频
     STARTED 开始
     */
    private String action;

    /**
     * action动作属性的分装
     */
    private MediaAction mediaAction;

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
}
