package com.amiotisse.ubsunu.profile.controller;

import com.amiotisse.ubsunu.profile.ApiError;
import com.amiotisse.ubsunu.profile.ApiErrors;
import com.amiotisse.ubsunu.profile.model.Profile;
import com.amiotisse.ubsunu.profile.model.UserToken;
import com.amiotisse.ubsunu.profile.model.builder.ProfileBuilder;
import com.himnabil.alphau.client.error.InvalidTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author himna
 * @since 4/16/2017.
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {
    private Logger log = LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public Profile getProfile (
            @RequestAttribute("claims") UserToken userToken
    ){
        log.info("GET /profile : userToken : {}" , userToken);

        return new ProfileBuilder()
                .setUserId(userToken.getId())
                .setUserName(userToken.getUserName())
                .setUserType(userToken.getUserType())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ApiError> handleInvalidTokenException (
            InvalidTokenException e) {
        log.error("Handle Exception ", e);
        return new ResponseEntity<>(ApiErrors.INVALID_TOKEN , HttpStatus.UNAUTHORIZED);
    }
}
