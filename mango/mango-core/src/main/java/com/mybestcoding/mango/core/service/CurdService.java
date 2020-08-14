package com.mybestcoding.mango.core.service;

import com.mybestcoding.mango.core.page.PageRequest;
import com.mybestcoding.mango.core.page.PageResult;

import java.util.List;

/**
 * 通用CURD接口
 */
public interface CurdService<T> {

    /**
     * 保存操作
     *
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 删除操作
     *
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除操作
     *
     * @param records
     * @return
     */
    int delete(List<T> records);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T findById(Long id);


    /**
     * 分页查询
     * 统一封装分页请求和结果，避免直接引入具体的分页对象
     *
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageRequest pageRequest);
}
