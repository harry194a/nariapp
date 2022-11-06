package com.tmx.nari.agm.model.models;

import com.tmx.nari.agm.entity.Role;
import com.tmx.nari.agm.entity.user.User;
import lombok.Value;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 18.09.22
 * Time: 02:27
 */
@Value
public class UserModel {

    UUID id;
    String userId;
    String email;
    String firstName;
    String lastName;
    String phone;
    String address;
    Role role;

    public static UserModel from(User user) {
        return new UserModel(
                user.getId(),
                user.getUserId(), 
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getAddress(),
                user.getRole()
        );
    }
}
