package com.yixue.xdatam.entity.data;

/**
 * @author IBM CHEN ZHI KAN
 * @create 2018/1/25
 * 系统使用记录
 */
public class SystemUseRecord {
  private String userId;//用户id
  private String courseId;//课次Id
  private String sectionId;//课次id
  private String starTime;
  private String endTime;
  private String spendTime;
  private String level;
  private String averageSpentTime;//平均做题时间
  private String questionNum;//做题数量
  private String isRight;//正答率

  public String getSpendTime() {
    return spendTime;
  }

  public void setSpendTime(String spendTime) {
    this.spendTime = spendTime;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getSectionId() {
    return sectionId;
  }

  public void setSectionId(String sectionId) {
    this.sectionId = sectionId;
  }

  public String getQuestionNum() {
    return questionNum;
  }

  public void setQuestionNum(String questionNum) {
    this.questionNum = questionNum;
  }

  public String getIsRight() {
    return isRight;
  }

  public void setIsRight(String isRight) {
    this.isRight = isRight;
  }

  public String getAverageSpentTime() {
    return averageSpentTime;
  }

  public void setAverageSpentTime(String averageSpentTime) {
    this.averageSpentTime = averageSpentTime;
  }

  public String getStarTime() {
    return starTime;
  }

  public void setStarTime(String starTime) {
    this.starTime = starTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

}
