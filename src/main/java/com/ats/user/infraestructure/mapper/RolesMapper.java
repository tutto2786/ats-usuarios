package com.ats.user.infraestructure.mapper;

import com.ats.user.domain.model.Permission;
import com.ats.user.domain.model.Role;
import com.ats.user.infraestructure.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel="spring")
public interface RolesMapper {
    @Mapping(target="permission", ignore= true)
    Role toEntity(RoleEntity roleEntity);

    @Mapping(target = "permission", ignore= true)
    RoleEntity toEntity(Role roleDomain);

    List<Role> toDomainLisr(Set<RoleEntity> roleEntitySet);
    Set<RoleEntity> toEntitySet(Set<Role> roleSet);
}
