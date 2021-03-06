package com.epam.conference.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends Entity {
    private int roleId;
    private String roleName;

    public Role(int roleId) {
        this.roleId = roleId;
    }
}
