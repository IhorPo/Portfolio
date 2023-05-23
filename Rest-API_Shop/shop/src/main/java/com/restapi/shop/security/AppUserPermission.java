package com.restapi.shop.security;

public enum AppUserPermission {
    // Permissions: READ & WRITE
    // READ: reading files only
    // WRITE: make changes into files
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
