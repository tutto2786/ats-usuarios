package com.ats.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Menu {
     Long id;
     String title;
     String path;

    private Module module; // N:1

    @Override public boolean equals(Object o){ return (o instanceof Menu m) && Objects.equals(id,m.id); }
    @Override public int hashCode(){ return Objects.hashCode(id); }
}
