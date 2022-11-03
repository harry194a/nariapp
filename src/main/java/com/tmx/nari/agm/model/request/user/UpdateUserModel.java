package com.tmx.nari.agm.model.request.user;

import com.tmx.nari.agm.entity.Role;
import com.tmx.nari.agm.entity.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Harutyun Badeyan
 * Date: 20.09.22
 * Time: 11:33
 */

    @EqualsAndHashCode
    @Getter
    @Setter
    @ToString
    public class UpdateUserModel {
        
        @NotEmpty
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private Role role;

        public User toEntity(User user) {
            user.setFirstName(this.getFirstName());
            user.setLastName(this.getLastName());
            user.setPhone(this.getPhone());
            user.setAddress(this.getAddress());
            user.setRole(this.getRole());
            return user;
        }
    }


