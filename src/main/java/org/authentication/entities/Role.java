package org.authentication.entities;

import lombok.*;
import org.authentication.enums.RoleEnum;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {
    private RoleEnum name;
    public Role(RoleEnum name) {
        this.name = name;
    }
}
