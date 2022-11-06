package com.tmx.nari.agm.model.response;


import com.tmx.nari.agm.entity.Role;
import com.tmx.nari.agm.model.models.UserModel;
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
    private String userId;
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
        response.setUserId(user.getUserId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setPhone(user.getPhone());
        response.setAddress(user.getAddress());
        response.setRole(user.getRole());

        return response;
    }
}
