package com.ats.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String passwordHash;
    private transient String repassword;
    private Set<Role> roles = new HashSet<>();
    private Set<Permission> profiles = new HashSet<>();

    public void addUser(Role r){
        roles.add(r);
        r.getUsers().remove(this);
    }
    public void removeUser(Role r)
    {
        roles.remove(r);
        r.getUsers().remove(this);
    }

}
