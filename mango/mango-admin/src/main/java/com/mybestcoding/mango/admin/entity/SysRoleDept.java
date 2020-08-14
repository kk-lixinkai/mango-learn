package com.mybestcoding.mango.admin.entity;

import java.io.Serializable;


public class SysRoleDept extends BaseModel implements Serializable {

    private Long roleId;

    private Long deptId;

    private static final long serialVersionUID = 1L;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

}