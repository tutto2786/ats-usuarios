package com.ats.user.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = {"modules", "roles"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {
    @EqualsAndHashCode.Include
    Long id;
    String code;
    String resource;
    String action;
    String scope;
    String description;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Long createdBy;
    Long updatedBy;

    Set<Module> modules = new HashSet<>();
    Set<Role> roles = new HashSet<>();

    public void addModule(Module m){ modules.add(m); m.getPermissions().add(this); }
    public void removeModule(Module m){ modules.remove(m); m.getPermissions().remove(this); }
    public void addRole(Role r){
        roles.add(r);
        r.getPermissions().add(this);
    }

    public void removeRole(Role r){
        roles.remove(r);
        r.getPermissions().remove(this);
    }


}

