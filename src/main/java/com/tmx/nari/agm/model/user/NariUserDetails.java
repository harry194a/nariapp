package com.tmx.nari.agm.model.user;

import com.tmx.nari.agm.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Harutyun Badeyan
 * Date: 04.10.22
 * Time: 00:26
 */
public class NariUserDetails implements UserDetails {

    private final String id;

    private final String email;
    private final String userName;

    private final String password;

    private final List<String> roles = new ArrayList<>();

    public NariUserDetails(
            final String userName,
            final String password,
            final List<String> roles,
            final String id, final String email) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.email = email;
        this.roles.addAll(roles);
    }

    public static NariUserDetails from(User user) {
        return new NariUserDetails(
                user.getFirstName(),
                user.getPassword(),
                List.of(user.getRole().name()),
                user.getId().toString(),
                user.getEmail());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> (GrantedAuthority) () -> role).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getRoles() {
        return roles;
    }
}
