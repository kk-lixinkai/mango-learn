package com.mybestcoding.mango.core.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 * Created By lixinkai on 2020/8/2
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<String, Object>();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Object getParams(String key) {
        return this.params.get(key);
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
