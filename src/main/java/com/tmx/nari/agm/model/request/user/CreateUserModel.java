package com.tmx.nari.agm.model.request.user;


import com.tmx.nari.agm.config.PasswordEncoder;
import com.tmx.nari.agm.entity.Role;
import com.tmx.nari.agm.entity.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Harutyun Badeyan
 * Date: 17.09.22
 * Time: 18:51
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreateUserModel {
    @NotEmpty
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String password;
    private Role role;

    public User toEntity() {
        User user = new User();
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPhone(this.phone);
        user.setAddress(this.address);
        user.setPassword(PasswordEncoder.encode(password));
        user.setRole(this.role);
        return user;
    }
}
