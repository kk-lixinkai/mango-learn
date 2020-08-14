package com.mybestcoding.mango.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRoleMenu extends BaseModel implements Serializable {

    private Long roleId;

    private Long menuId;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}