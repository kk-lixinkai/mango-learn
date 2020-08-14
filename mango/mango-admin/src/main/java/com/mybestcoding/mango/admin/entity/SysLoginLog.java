package com.mybestcoding.mango.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class SysLoginLog extends BaseModel implements Serializable {

    private String userName;

    private String status;

    private String ip;

    private static final long serialVersionUID = 1L;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

}