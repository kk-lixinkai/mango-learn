package com.mybestcoding.mango.admin.controller;

import com.mybestcoding.mango.admin.entity.SysDept;
import com.mybestcoding.mango.admin.service.SysDeptService;
import com.mybestcoding.mango.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By lixinkai on 2020/8/5
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PreAuthorize("hasAuthority('sys:dept:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value = "/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}
