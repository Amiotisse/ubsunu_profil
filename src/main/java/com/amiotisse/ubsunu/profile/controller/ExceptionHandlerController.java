package com.amiotisse.ubsunu.profile.controller;

import com.amiotisse.ubsunu.profile.ApiError;
import com.amiotisse.ubsunu.profile.ApiErrors;
import com.himnabil.alphau.client.error.ErrorWhenRecedingPublicKeyException;
import com.himnabil.alphau.client.error.InvalidTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author himna
 * @since 4/17/2017.
 */
@Controller
public class ExceptionHandlerController {

    private Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ResponseBody
    @ExceptionHandler(ErrorWhenRecedingPublicKeyException.class)
    public ResponseEntity<ApiError> handleErrorWhenRecedingPublicKeyException(
            ErrorWhenRecedingPublicKeyException e) {
        log.error("Handle Exception ", e);
        return new ResponseEntity<ApiError>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
