package com.server.reko.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity//映射为一张表
@Table(name = "user_detail")
@EntityListeners(AuditingEntityListener.class)
public class UserDetail  implements Serializable {
    //用户编号
    @Id
    private Long uDnumber;

    //生日
    @Column(nullable = true,length=30)
    @Temporal(TemporalType.TIMESTAMP)//它将日期和时间值从Java Object转换为兼容的数据库类型
    private Date birthday;

    //性别
    @Column (nullable = true,length=20)
    private String sex;

    //昵称
    @Column (nullable = true,length=255)
    private String nickName;

    //头像URL
    @Column (nullable = true,length=255,unique = true)//设定不能为空
    private String portrait;

    //创建活动数
    private int createANumber;
    //删除活动数
    private int joinANubmber;
    //参加活动\
    @Column (nullable = true,length=2048)
    private String joinActivity;
    //关注活动
    @Column (nullable = true,length=2048)
    private String attentionANumber;


    public Long getuDnumber() {
        return uDnumber;
    }

    public void setuDnumber(Long uDnumber) {
        this.uDnumber = uDnumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getCreateANumber() {
        return createANumber;
    }

    public void setCreateANumber(int createANumber) {
        this.createANumber = createANumber;
    }

    public int getJoinANubmber() {
        return joinANubmber;
    }

    public void setJoinANubmber(int joinANubmber) {
        this.joinANubmber = joinANubmber;
    }

    public String getAttentionANumber() {
        return attentionANumber;
    }

    public void setAttentionANumber(String attentionANumber) {
        this.attentionANumber = attentionANumber;
    }

    public String getJoinActivity() {
        return joinActivity;
    }

    public void setJoinActivity(String joinActivity) {
        this.joinActivity = joinActivity;
    }

    public UserDetail(){};

    public UserDetail(Long uDnumber, Date birthday, String sex, String nickName, String portrait, int createANumber, int joinANubmber, String joinActivity, String attentionANumber) {
        this.uDnumber = uDnumber;
        this.birthday = birthday;
        this.sex = sex;
        this.nickName = nickName;
        this.portrait = portrait;
        this.portrait = portrait;
        this.createANumber = createANumber;
        this.joinANubmber = joinANubmber;
        this.joinActivity = joinActivity;
        this.attentionANumber = attentionANumber;
    }
}
