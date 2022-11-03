package com.tmx.nari.agm.model.request.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 17.09.22
 * Time: 20:58
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreatePasswordRequest {

    private String oldPassword;
    private String newPassword;
    private String repeatedNewPass;
}
