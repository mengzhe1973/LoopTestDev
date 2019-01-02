package com.puan.looptestdev.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by kiros on 2018/12/22.
 */

@Entity
public class User {

    @Id
    private Long id;
    private String phone;
    private String password;
    @Generated(hash = 800558714)
    public User(Long id, String phone, String password) {
        this.id = id;
        this.phone = phone;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
