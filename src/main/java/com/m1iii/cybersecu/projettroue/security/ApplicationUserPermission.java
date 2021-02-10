package com.m1iii.cybersecu.projettroue.security;

/**
 * Enumération pour configurer les différentes permissions disponibles par table
 */
public enum ApplicationUserPermission {

    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
