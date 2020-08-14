package com.mybestcoding.mango.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRole extends BaseModel implements Serializable {

    private String name;

    private String remark;

    private Byte delFlag;

    private static final long serialVersionUID = 1L;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

}