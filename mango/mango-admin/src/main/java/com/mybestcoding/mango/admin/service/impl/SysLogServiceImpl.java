package com.mybestcoding.mango.admin.service.impl;

import com.mybestcoding.mango.admin.entity.SysLog;
import com.mybestcoding.mango.admin.mapper.SysLogMapper;
import com.mybestcoding.mango.admin.service.SysLogService;
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
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParams("userName");
        if (label != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysLogMapper);
    }
}
