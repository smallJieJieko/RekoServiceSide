package com.server.reko.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity//映射为一张表
@Table(name = "friend_request")
@EntityListeners(AuditingEntityListener.class)
public class FriendRequest implements Serializable {
    //请求编号
    @Id
    private Long requestNumber;
    //请求者
    @Column(nullable = false,length=30)
    private Long sendApplication;
    //接收请求者
    @Column(nullable = false,length=30)
    private Long getApplication;
    //请求状态
    @Column(nullable = false,length=30)
    private String state = "wait";

    public Long getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Long requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Long getSendApplication() {
        return sendApplication;
    }

    public void setSendApplication(Long sendApplication) {
        this.sendApplication = sendApplication;
    }

    public Long getGetApplication() {
        return getApplication;
    }

    public void setGetApplication(Long getApplication) {
        this.getApplication = getApplication;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public FriendRequest(){}

    public FriendRequest(Long requestNumber, Long sendApplication, Long getApplication, String state) {
        this.requestNumber = requestNumber;
        this.sendApplication = sendApplication;
        this.getApplication = getApplication;
        this.state = state;
    }
}
