package com.obaydullah.ucm.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "user")
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    private String userId;
    @Column( nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    @Getter(AccessLevel.NONE)
    private String password;
    @Column(length = 10000,columnDefinition = "TEXT")
    private String about;
    @Column(length = 10000,columnDefinition = "TEXT")
    private String profilePic;
    private String phoneNumber;

    @Getter(AccessLevel.NONE)
    private boolean enabled = true;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    /// Self , Google , Facebook , GitHub
    private Providers provider = Providers.SELF;
    private String providerId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> roles= roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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
        return this.enabled;
    }
}
