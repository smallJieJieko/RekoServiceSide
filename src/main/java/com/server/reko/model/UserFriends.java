package com.server.reko.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity//映射为一张表
@Table(name = "user_friends")
@EntityListeners(AuditingEntityListener.class)
public class UserFriends implements Serializable {
    //关系编号
    @Id
    private Long relationshipNumber;
    //用户编号
    @Column(nullable = false,length=20)
    private Long uBnumber;
    //好友编号
    @Column(nullable = false,length=20)
    private Long uFnumber;

    public UserFriends(){}

    public UserFriends(Long relationshipNumber, Long uBnumber, Long uFnumber) {
        this.relationshipNumber = relationshipNumber;
        this.uBnumber = uBnumber;
        this.uFnumber = uFnumber;
    }

    public UserFriends(Long uBnumber, Long uFnumber) {
        this.uBnumber = uBnumber;
        this.uFnumber = uFnumber;
    }

    public Long getRelationshipNumber() {
        return relationshipNumber;
    }

    public void setRelationshipNumber(Long relationshipNumber) {
        this.relationshipNumber = relationshipNumber;
    }

    public Long getuBnumber() {
        return uBnumber;
    }

    public void setuBnumber(Long uBnumber) {
        this.uBnumber = uBnumber;
    }

    public Long getuFnumber() {
        return uFnumber;
    }

    public void setuFnumber(Long uFnumber) {
        this.uFnumber = uFnumber;
    }
}
