package com.ats.user.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "permissions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Long id;

    @Column(nullable = false)
    String code;

    @Column(nullable = false)
    String resource;

    @Column(nullable = false)
    String action;

    @Column(nullable = false)
    String scope;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    boolean active;

    @Column(nullable = false)
    LocalDateTime createdAt;

    @Column(nullable = false)
    LocalDateTime updatedAt;

    @Column(nullable = false)
    Long createdBy;

    @Column(nullable = false)
    Long updatedBy;

    /**
     * Relación inversa con módulos
     */
    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
    Set<ModuleEntity> modules = new HashSet<>();

    /**
     * Relación inversa con roles (role_permission)
     */
    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
    Set<RoleEntity> roles = new HashSet<>();
}

