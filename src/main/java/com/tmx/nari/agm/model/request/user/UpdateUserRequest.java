package com.tmx.nari.agm.model.request.user;

import com.tmx.nari.agm.entity.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 21:10
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Role role;

    public UpdateUserModel toUpdateModel() {
        UpdateUserModel model = new UpdateUserModel();
        model.setFirstName(this.firstName);
        model.setLastName(this.lastName);
        model.setPhone(this.phone);
        model.setAddress(this.address);
        model.setRole(this.role);
        return model;
    }
}
