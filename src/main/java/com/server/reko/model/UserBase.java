package com.server.reko.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity//映射为一张表
@Table(name = "user_base")
@EntityListeners(AuditingEntityListener.class)
public class UserBase implements Serializable {
    @Id//设定为主键
    private Long uBnumber;

    @Column (nullable = false,length=255,unique = true)//设定不能为空
    private String account;

    @Column (length =255)
    private String  passWord;

    public Long getuBnumber() {
        return uBnumber;
    }

    public void setuBnumber(Long uBnumber) {
        this.uBnumber = uBnumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserBase(){

    }
    public UserBase(Long uBnumber, String account, String passWord) {
        this.uBnumber = uBnumber;
        this.account = account;
        this.passWord = passWord;
    }
}
