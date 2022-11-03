package com.tmx.nari.agm.model.user;


import com.tmx.nari.agm.entity.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 21:35
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserResponse {
    
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Role role;
    
    public static UserResponse from(
            final UserModel user) {

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setPhone(user.getPhone());
        response.setAddress(user.getAddress());
        response.setRole(user.getRole());

        return response;
    }
}
