package com.ats.user.infraestructure.mapper;
import com.ats.user.domain.model.User;
import com.ats.user.infraestructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface UserMapper {
    @Mapping(target="roles", ignore=true)
    User toDomain(UserEntity userEntity);
    @Mapping(target="roles", ignore = true)
    UserEntity toEntity(User userDomain);


}
