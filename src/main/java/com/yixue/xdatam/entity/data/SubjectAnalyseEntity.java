package com.yixue.xdatam.entity.data;

/**
 * 题目分析类
 *
 * @author IBM CHEN ZHI KAN
 * @create 2017/8/25
 */
public class SubjectAnalyseEntity {
    private Long id;
    private String tagCode;//知识点编号
    private String tagName;//知识点描述
    private String serialNumber;//题目自定义编号
    private String questionId;//题目ID
    private String difficulty;//题目难度
    private String tagCodeCount;//知识点次数
    private String spentTimeAvg;//平均答题时长
    private String estimatesTimeAvg;//预估平均答题时长
    private String submitTime;//提交日期
    private String rightRate;//正确率
    private String subject;//科目


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTagCodeCount() {
        return tagCodeCount;
    }

    public void setTagCodeCount(String tagCodeCount) {
        this.tagCodeCount = tagCodeCount;
    }

    public String getSpentTimeAvg() {
        return spentTimeAvg;
    }

    public void setSpentTimeAvg(String spentTimeAvg) {
        this.spentTimeAvg = spentTimeAvg;
    }

    public String getEstimatesTimeAvg() {
        return estimatesTimeAvg;
    }

    public void setEstimatesTimeAvg(String estimatesTimeAvg) {
        this.estimatesTimeAvg = estimatesTimeAvg;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getRightRate() {
        return rightRate;
    }

    public void setRightRate(String rightRate) {
        this.rightRate = rightRate;
    }
}
