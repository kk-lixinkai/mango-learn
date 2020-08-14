package com.mybestcoding.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 * Created By lixinkai on 2020/8/5
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private static final long serialVersionUID = 7775317478767369196L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
