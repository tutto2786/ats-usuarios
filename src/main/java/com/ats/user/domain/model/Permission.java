package com.ats.user.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {
    Long id;
    String code;
    String description;

    private Set<User> users = new HashSet<>();
    private Set<Module> modules = new HashSet<>();

    public void addUser(User u){ users.add(u); u.getPermissions().add(this); }
    public void removeUser(User u){ users.remove(u); u.getPermissions().remove(this); }
    public void addModule(Module m){ modules.add(m); m.getPermissions().add(this); }
    public void removeModule(Module m){ modules.remove(m); m.getPermissions().remove(this); }


}

