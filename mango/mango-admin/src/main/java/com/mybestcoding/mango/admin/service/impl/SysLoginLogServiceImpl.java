package com.mybestcoding.mango.admin.service.impl;

import com.mybestcoding.mango.admin.entity.SysLoginLog;
import com.mybestcoding.mango.admin.mapper.SysLoginLogMapper;
import com.mybestcoding.mango.admin.service.SysLoginLogService;
import com.mybestcoding.mango.core.page.MyBatisPageHelper;
import com.mybestcoding.mango.core.page.PageRequest;
import com.mybestcoding.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By lixinkai on 2020/8/3
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {
    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public int save(SysLoginLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLoginLogMapper.insertSelective(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLoginLog> records) {
        for (SysLoginLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParams("userName");
        if (userName != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByUserName", userName);
        }
        Object status = pageRequest.getParams("status");
        if (status != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByStatus", status);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper);
    }
}
