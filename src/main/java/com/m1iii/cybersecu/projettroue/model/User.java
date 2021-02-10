package com.m1iii.cybersecu.projettroue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.m1iii.cybersecu.projettroue.security.ApplicationUserRole;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String creditCardNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private ApplicationUserRole userRole;

    @Transient
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private String password;
    private String username;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialNonExpired;
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "book_owner",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_book"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Book> booksOwned;

    public User(Set<? extends GrantedAuthority> grantedAuthorities, String password, String username, boolean isAccountNonLocked, boolean isAccountNonExpired, boolean isCredentialNonExpired, boolean isEnabled) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
    }

    public User(Long id, String address, String creditCardNumber, String email, ApplicationUserRole userRole, Set<? extends GrantedAuthority> grantedAuthorities, String password, String username, boolean isAccountNonLocked, boolean isAccountNonExpired, boolean isCredentialNonExpired, boolean isEnabled, Set<Book> booksOwned) {
        this.id = id;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.email = email;
        this.userRole = userRole;
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
        this.booksOwned = booksOwned;
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
