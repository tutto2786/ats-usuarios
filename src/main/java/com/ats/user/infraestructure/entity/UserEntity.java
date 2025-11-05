package com.ats.user.infraestructure.entity;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
            @Generated
    Long id;
    String name;
    String lastName;
    String indicativo;
    Integer telefono;
    String password;


}
