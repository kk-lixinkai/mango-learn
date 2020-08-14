package com.mybestcoding.mango.admin.service;

import com.mybestcoding.mango.admin.entity.SysDict;
import com.mybestcoding.mango.core.service.CurdService;

import java.util.List;

/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {

    /**
     * 根据名称查询
     *
     * @param label
     * @return
     */
    List<SysDict> findByLabel(String label);
}
