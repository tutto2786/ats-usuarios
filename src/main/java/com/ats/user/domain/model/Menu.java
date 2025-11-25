package com.ats.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "module")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menu {

    @EqualsAndHashCode.Include
    Long id;
    String title;
    String path;
    Module module;
    Integer orderIndex;
    String requiredPermissionCode;
    boolean active;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}

