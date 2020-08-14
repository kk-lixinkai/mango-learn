package com.mybestcoding.mango.admin.service;

import com.mybestcoding.mango.admin.entity.SysMenu;
import com.mybestcoding.mango.admin.entity.SysRole;
import com.mybestcoding.mango.admin.entity.SysRoleMenu;
import com.mybestcoding.mango.core.service.CurdService;

import java.util.List;

/**
 * 角色管理
 * Created By lixinkai on 2020/8/3
 */
public interface SysRoleService extends CurdService<SysRole> {
    /**
     * 查询全部
     *
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     *
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     *
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);


    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);
}
