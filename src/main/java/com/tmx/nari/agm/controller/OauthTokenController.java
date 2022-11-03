package com.tmx.nari.agm.controller;


import com.tmx.nari.agm.config.PasswordEncoder;
import com.tmx.nari.agm.config.oauth.JwtService;
import com.tmx.nari.agm.config.oauth.OauthTokenRequest;
import com.tmx.nari.agm.config.oauth.OauthTokenResponse;
import com.tmx.nari.agm.model.exeption.ErrorCode;
import com.tmx.nari.agm.model.exeption.ServiceException;
import com.tmx.nari.agm.model.user.NariUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Harutyun Badeyan
 * Date: 02.11.22
 * Time: 18:56
 */

@RestController
@RequestMapping("/api/oauth")
public class OauthTokenController {

    private final UserDetailsService userService;
    private final JwtService jwtService;

    @Autowired
    public OauthTokenController(
            final UserDetailsService userService,
            final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }


    @PostMapping("/token")
    public OauthTokenResponse getToken(
            @RequestBody OauthTokenRequest request
    ) {
        NariUserDetails user = (NariUserDetails) userService.loadUserByUsername(request.getUserName());
        if (!PasswordEncoder.isPasswordMatch(request.getPassword(), user.getPassword())) {
            throw new ServiceException("Invalid credentials", ErrorCode.INVALID_CREDENTIALS);
        }
        String token = jwtService.createJwt(user);
        return new OauthTokenResponse(token);
    }
}
