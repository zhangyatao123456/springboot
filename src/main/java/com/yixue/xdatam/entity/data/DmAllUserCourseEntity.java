package com.yixue.xdatam.entity.data;

/**
 * 学生所学课程信息实体类
 *
 * @author wangruzuo
 * @create 2017/8/25
 */
public class DmAllUserCourseEntity {
    private Integer id;
    private Integer cid;//学科id
    private String cname;//学科 0：所有学科，1：英语，2：数学，3：语文，4：物理
    private Integer online;//线上否 0否，代表加盟校，1是，代表线上
    private Integer user_id;//用户ID
    private String user_name;//账号
    private String real_name;//姓名
    private String school_name;//校区名
    private Integer course_id;//课程id
    private String course_name;//课程
    private Integer course_term;//课程-时期id
    private String course_stage;//课程-时期说明
    private Integer section_id;//课次id
    private String section_name;//课次
    private String topicId;//专题ID
    private String study_card;//学习卡
    private String create_time;//账号创建时间
    private String last_submit_time;//账号使用更新时间
    private String user_status;//用户状态
    private String official_user_id;//官网ID
    private String twx_user_id;//天王星ID
    private String year;//建课-年


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public Integer getOnline() {
    return online;
  }

  public void setOnline(Integer online) {
    this.online = online;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getReal_name() {
    return real_name;
  }

  public void setReal_name(String real_name) {
    this.real_name = real_name;
  }

  public String getSchool_name() {
    return school_name;
  }

  public void setSchool_name(String school_name) {
    this.school_name = school_name;
  }

  public Integer getCourse_id() {
    return course_id;
  }

  public void setCourse_id(Integer course_id) {
    this.course_id = course_id;
  }

  public String getCourse_name() {
    return course_name;
  }

  public void setCourse_name(String course_name) {
    this.course_name = course_name;
  }

  public Integer getCourse_term() {
    return course_term;
  }

  public void setCourse_term(Integer course_term) {
    this.course_term = course_term;
  }

  public String getCourse_stage() {
    return course_stage;
  }

  public void setCourse_stage(String course_stage) {
    this.course_stage = course_stage;
  }

  public Integer getSection_id() {
    return section_id;
  }

  public void setSection_id(Integer section_id) {
    this.section_id = section_id;
  }

  public String getSection_name() {
    return section_name;
  }

  public void setSection_name(String section_name) {
    this.section_name = section_name;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getStudy_card() {
    return study_card;
  }

  public void setStudy_card(String study_card) {
    this.study_card = study_card;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public String getLast_submit_time() {
    return last_submit_time;
  }

  public void setLast_submit_time(String last_submit_time) {
    this.last_submit_time = last_submit_time;
  }

  public String getUser_status() {
    return user_status;
  }

  public void setUser_status(String user_status) {
    this.user_status = user_status;
  }

  public String getOfficial_user_id() {
    return official_user_id;
  }

  public void setOfficial_user_id(String official_user_id) {
    this.official_user_id = official_user_id;
  }

  public String getTwx_user_id() {
    return twx_user_id;
  }

  public void setTwx_user_id(String twx_user_id) {
    this.twx_user_id = twx_user_id;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
