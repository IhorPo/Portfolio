package com.restapi.shop.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.restapi.shop.security.AppUserPermission.*;

public enum AppUserRole {
    // user can only read data
    USER(Sets.newHashSet(PRODUCT_READ,CUSTOMER_READ)),
    // admin have all permissions
    ADMIN(Sets.newHashSet(PRODUCT_READ,PRODUCT_WRITE,CUSTOMER_READ,CUSTOMER_WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions(){
        return permissions;
    }
}
