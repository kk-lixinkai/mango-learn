package com.mybestcoding.mango.admin.controller;

import com.mybestcoding.mango.admin.entity.SysConfig;
import com.mybestcoding.mango.admin.service.SysConfigService;
import com.mybestcoding.mango.core.http.HttpResult;
import com.mybestcoding.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;

/**
 * 系统配置控制器
 * Created By lixinkai on 2020/8/5
 */
@RestController
@RequestMapping("/config")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    @PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @PreAuthorize("hasAuthority('sys:config:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    @PreAuthorize("hasAuthority('sys:config:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:config:view')")
    @GetMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysConfigService.findByLabel(label));
    }
}
