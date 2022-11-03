package com.tmx.nari.agm.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

/**
 * Created by Harutyun Badeyan
 * Date: 15.09.22
 * Time: 13:56
 */
public class PasswordEncoder {
    static BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(10, new SecureRandom());

    public static String encode(String passWord) {
        return bCryptPasswordEncoder.encode(passWord);

    }

    public static boolean isPasswordMatch(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);

    }
}
