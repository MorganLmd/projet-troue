package com.m1iii.cybersecu.projettroue.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.m1iii.cybersecu.projettroue.security.ApplicationUserPermission.*;

/**
 * Roles de l'application avec les autorisations associées
 * L'admin a toutes les autorisations
 * le client n'en as pas, on lui donnera accès à des endpoints de l'API au cas par cas
 */
public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(CLIENT_READ, CLIENT_WRITE, BOOK_READ, BOOK_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissionSet = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissionSet.add(new SimpleGrantedAuthority("ROLE" + this.name()));

        return permissionSet;
    }
}
