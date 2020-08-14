package com.mybestcoding.mango.admin.service;

import com.mybestcoding.mango.admin.entity.SysConfig;
import com.mybestcoding.mango.core.service.CurdService;

import java.util.List;

/**
 * 系统配置管理
 */
public interface SysConfigService extends CurdService<SysConfig> {
    /**
     * 根据名称查询
     *
     * @param label
     * @return
     */
    List<SysConfig> findByLabel(String label);
}
