package com.ats.user.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"menus", "permissions"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Module {
    @EqualsAndHashCode.Include
    Long id;
    String code;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    boolean active;
    Long createdBy;
    Long updatedBy;

    Set<Menu> menus = new HashSet<>();  // 1:N
    Set<Permission> permissions = new HashSet<>(); // N:M vía permission_modules

    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.setModule(this);
    }

    public void addPermission(Permission p) {
        permissions.add(p);
        p.getModules().add(this);
    }

    public void removePermission(Permission p) {
        permissions.remove(p);
        p.getModules().remove(this);
    }
}
