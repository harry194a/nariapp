package com.tmx.nari.agm.controller.user;


import com.tmx.nari.agm.model.request.user.CreateUserRequest;
import com.tmx.nari.agm.model.request.user.UpdateUserRequest;
import com.tmx.nari.agm.model.request.user.CreatePasswordRequest;
import com.tmx.nari.agm.model.user.UserModel;
import com.tmx.nari.agm.model.user.UserResponse;
import com.tmx.nari.agm.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 21:27
 */
@RestController
@RequestMapping("api/user/")
@Api("user API")
public class UserController {
    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ApiOperation(
            value = "create user")
    public ResponseEntity<UserResponse> create(
            @Valid @RequestBody CreateUserRequest request) {
        UserModel item = service.create(request.toCreateModel());
        UserResponse response = UserResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(
            value = "find User")
    public ResponseEntity<UserResponse> findById(
            @Valid @PathVariable("id") UUID id) {
        UserModel item = service.getById(id);
        UserResponse response = UserResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "update User")
    public ResponseEntity<UserResponse> update(
            @Valid @RequestBody UpdateUserRequest request,
            @Valid @PathVariable("id") UUID id) {
        UserModel item = service.update(id, request.toUpdateModel());
        UserResponse response = UserResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "delete User")
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-password/{id}")
    @ApiOperation(value = "update password")
    public void updatePassword(
            @Valid @RequestBody CreatePasswordRequest request,
            @Valid @PathVariable("id") UUID id) {
        service.changePassword(id, request);
    }
}
