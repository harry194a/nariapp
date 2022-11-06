package com.tmx.nari.agm.model.request.user;

import com.tmx.nari.agm.entity.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 21:03
 */

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreateUserRequest {

    private String email;
    private String userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String password;
    private Role role;
    
    public CreateUserModel toCreateModel() {
        
        CreateUserModel user = new CreateUserModel();
        user.setEmail(this.email);
        user.setUserId(this.userId);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPhone(this.phone);
        user.setAddress(this.address);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}
