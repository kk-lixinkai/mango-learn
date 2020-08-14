package com.mybestcoding.mango.admin.controller;

import com.mybestcoding.mango.admin.entity.SysLoginLog;
import com.mybestcoding.mango.admin.service.SysLoginLogService;
import com.mybestcoding.mango.core.http.HttpResult;
import com.mybestcoding.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录日志控制器
 * Created By lixinkai on 2020/8/5
 */
@RestController
@RequestMapping("/loginlog")
public class SysLoginLogController {
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PreAuthorize("hasAuthority('sys:loginlog:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:loginlog:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
