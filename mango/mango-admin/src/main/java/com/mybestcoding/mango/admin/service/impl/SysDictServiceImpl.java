package com.mybestcoding.mango.admin.service.impl;

import com.mybestcoding.mango.admin.entity.SysDict;
import com.mybestcoding.mango.admin.mapper.SysDictMapper;
import com.mybestcoding.mango.admin.service.SysDictService;
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
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParams("label");
        if (label != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysDictMapper);
    }
}
