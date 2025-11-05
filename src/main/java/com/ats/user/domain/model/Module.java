package com.ats.user.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Module {
    Long id;
    String code;        // p.ej. "POSTULANTES"
    String name;
    String description;

    private Role role;                          // 1:N desde Role
    private Set<Menu> menus = new HashSet<>();  // 1:N
    private Set<Permission> permissions = new HashSet<>(); // N:M vía permission_modules

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
