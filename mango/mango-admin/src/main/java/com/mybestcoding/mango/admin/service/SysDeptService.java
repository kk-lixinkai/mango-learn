package com.mybestcoding.mango.admin.service;

import com.mybestcoding.mango.admin.entity.SysDept;
import com.mybestcoding.mango.core.service.CurdService;

import java.util.List;

/**
 * 机构管理
 */
public interface SysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     *
     * @return
     */
    List<SysDept> findTree();
}
