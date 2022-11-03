package com.tmx.nari.agm.entity.user;

import com.tmx.nari.agm.entity.Role;
import com.tmx.nari.agm.entity.common.AuditableBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 20:11
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AuditableBaseEntity {

    @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    
}

