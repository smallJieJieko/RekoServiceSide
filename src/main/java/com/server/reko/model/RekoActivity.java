package com.server.reko.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity//映射为一张表
@Table(name = "RekoActivity")
@EntityListeners(AuditingEntityListener.class)
public class RekoActivity implements Serializable {
    @Id//设定为主键
    private Long aNumber;
    //创建者id
    @Column(nullable = false,length=20)
    private Long createrNumber;
    //活动名称
    @Column (nullable = false,length=20)
    private String aName;

    //标签1标签2
    @Column (nullable = false,length=20)
    private String label1Type;
    @Column (nullable = false,length=20)
    private String label2Site;
    //图片
    @Column (nullable = false,length=255)//设定不能为空
    private String photograph;
    //内容类型
    @Column (nullable = false,length=20)
    private String contentType;
    //人数
    private int headcount;
    //活动状态
    @Column (nullable = false,length=20)
    private String activityState;
    //活动简介
    @Column (nullable = false,length=512)
    private String intro;
    //活动详情
    @Column (nullable = false,length=2048)
    private String detail;
    //活动成员
    @Column (length=2048)
    private String memberNumber;
    //活动开始时间
    @Column(nullable = false,length=30)
    @Temporal(TemporalType.TIMESTAMP)//它将日期和时间值从Java Object转换为兼容的数据库类型
    private Date startTime;
    //活动结束时间
    @Column(nullable = false,length=30)
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;

    public Long getaNumber() {
        return aNumber;
    }

    public void setaNumber(Long aNumber) {
        this.aNumber = aNumber;
    }

    public Long getCreaterNumber() {
        return createrNumber;
    }

    public void setCreaterNumber(Long createrNumber) {
        this.createrNumber = createrNumber;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getLabel1Type() {
        return label1Type;
    }

    public void setLabel1Type(String label1Type) {
        this.label1Type = label1Type;
    }

    public String getLabel2Site() {
        return label2Site;
    }

    public void setLabel2Site(String label2Site) {
        this.label2Site = label2Site;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    public RekoActivity(){}
    public RekoActivity(Long aNumber, Long createrNumber, String aName, String label1Type,
                        String label2Site, String photograph, String contentType, int headcount,
                        String activityState, String intro, String detail,
                        String memberNumber, Date startTime, Date finishTime) {
        this.aNumber = aNumber;
        this.createrNumber = createrNumber;
        this.aName = aName;
        this.label1Type = label1Type;
        this.label2Site = label2Site;
        this.photograph = photograph;
        this.contentType = contentType;
        this.headcount = headcount;
        this.activityState = activityState;
        this.intro = intro;
        this.detail = detail;
        this.memberNumber = memberNumber;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
}
