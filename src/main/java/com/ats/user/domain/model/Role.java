package com.ats.user.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"users", "permissions"})
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Role {
    @EqualsAndHashCode.Include
    Long id;
    String name;
    String description;
    boolean active;
    Long createdBy;
    Long updatedBy;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime updateAt;
    Set<User> users = new HashSet<>();
    Set<Permission> permissions = new HashSet<>();

    public void addUser(User u) {
        users.add(u);
        u.getRoles().add(this);
    }

    public void removeUser(User u) {
        users.remove(u);
        u.getRoles().remove(this);
    }

    public void addPermission(Permission p) {
        permissions.add(p);
        p.getRoles().add(this);
    }

    public void removePermission(Permission p) {
        permissions.remove(p);
        p.getRoles().remove(this);
    }


}
