package com.mybestcoding.mango.admin.controller;

import com.mybestcoding.mango.admin.entity.SysLog;
import com.mybestcoding.mango.admin.service.SysLogService;
import com.mybestcoding.mango.core.http.HttpResult;
import com.mybestcoding.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 操作日志控制器
 * Created By lixinkai on 2020/8/5
 */
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @PreAuthorize("hasAuthority('sys:log:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:log:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }
}
