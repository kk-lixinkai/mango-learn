package com.mybestcoding.mango.admin.service;

import com.mybestcoding.mango.admin.entity.SysUser;
import com.mybestcoding.mango.admin.entity.SysUserRole;
import com.mybestcoding.mango.core.page.PageRequest;
import com.mybestcoding.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * 用户管理
 */
public interface SysUserService extends CurdService<SysUser> {

    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     *
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     *
     * @param pageRequest
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);

}
