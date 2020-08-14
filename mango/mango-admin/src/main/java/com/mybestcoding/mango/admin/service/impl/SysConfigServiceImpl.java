package com.mybestcoding.mango.admin.service.impl;

import com.mybestcoding.mango.admin.entity.SysConfig;
import com.mybestcoding.mango.admin.mapper.SysConfigMapper;
import com.mybestcoding.mango.admin.service.SysConfigService;
import com.mybestcoding.mango.core.page.MyBatisPageHelper;
import com.mybestcoding.mango.core.page.PageRequest;
import com.mybestcoding.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created By lixinkai on 2020/8/3
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }

    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParams("label");
        if (label != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper);
    }
}
