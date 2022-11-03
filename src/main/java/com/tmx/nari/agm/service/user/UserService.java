package com.tmx.nari.agm.service.user;

import com.tmx.nari.agm.model.request.user.CreateUserModel;
import com.tmx.nari.agm.model.request.user.UpdateUserModel;
import com.tmx.nari.agm.model.request.user.CreatePasswordRequest;
import com.tmx.nari.agm.model.user.UserModel;

import java.util.UUID;

;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 20:53
 */
public interface UserService {
    UserModel create(final CreateUserModel request);

    UserModel update(final UUID id, final UpdateUserModel model);

    UserModel getById(final UUID id);

    void delete(final UUID id);
    
    void changePassword(
            final UUID id,
            final CreatePasswordRequest request);
}
