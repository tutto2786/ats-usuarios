package com.ats.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Role {
    private Long id;
    private String name;
    private String description;
    private Set<User> users;
    private Set<Module> modules;

    public void addUser(User u){
        users.add(u);
        u.getRoles().add(this);
    }
    public void removeUser(User u){
        users.remove(u);
        u.getRoles().remove(this);
    }
    public void addModule(Module m){ modules.add(m); m.setRole(this); }


}
