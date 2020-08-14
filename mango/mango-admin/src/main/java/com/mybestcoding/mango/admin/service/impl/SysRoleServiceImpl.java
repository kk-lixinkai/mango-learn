package com.mybestcoding.mango.admin.service.impl;

import com.mybestcoding.mango.admin.constant.SysConstants;
import com.mybestcoding.mango.admin.entity.SysMenu;
import com.mybestcoding.mango.admin.entity.SysRole;
import com.mybestcoding.mango.admin.entity.SysRoleMenu;
import com.mybestcoding.mango.admin.mapper.SysMenuMapper;
import com.mybestcoding.mango.admin.mapper.SysRoleMapper;
import com.mybestcoding.mango.admin.mapper.SysRoleMenuMapper;
import com.mybestcoding.mango.admin.service.SysRoleService;
import com.mybestcoding.mango.core.page.MyBatisPageHelper;
import com.mybestcoding.mango.core.page.PageRequest;
import com.mybestcoding.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By lixinkai on 2020/8/4
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            // 如果是超级管理员，返回全部
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu record : records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }

    @Override
    public int save(SysRole record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParams("name");
        if (label != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }

    public SysRoleMapper getSysRoleMapper() {
        return sysRoleMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }
}
