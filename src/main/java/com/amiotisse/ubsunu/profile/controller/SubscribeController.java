package com.amiotisse.ubsunu.profile.controller;

import com.amiotisse.ubsunu.profile.model.Profile;
import com.amiotisse.ubsunu.profile.model.ProfileSubscriptionRequest;
import com.amiotisse.ubsunu.profile.model.builder.ProfileBuilder;
import com.amiotisse.ubsunu.profile.model.transform.ProfileSubscriptionRequestDTO;
import com.amiotisse.ubsunu.profile.repository.ProfileRepository;
import com.himnabil.alphau.client.AlphaUFiegnClient;
import com.himnabil.alphau.client.model.UserSubscriptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author himna
 * @since 4/23/2017.
 */
@RestController
public class SubscribeController {

    private Logger log = LoggerFactory.getLogger(SubscribeController.class);

    ProfileSubscriptionRequestDTO profileSubscriptionRequestDTO ;
    AlphaUFiegnClient alphaUFiegnClient;
    ProfileRepository profileRepository;

    public SubscribeController(
            ProfileSubscriptionRequestDTO profileSubscriptionRequestDTO,
            AlphaUFiegnClient alphaUFiegnClient,
            ProfileRepository profileRepository
    ) {
        this.profileSubscriptionRequestDTO = profileSubscriptionRequestDTO;
        this.alphaUFiegnClient = alphaUFiegnClient;
        this.profileRepository = profileRepository;
    }

    @RequestMapping(path = "/subscribe", method = RequestMethod.POST)
    public ResponseEntity<?> subscribe(@RequestBody ProfileSubscriptionRequest request ){
        log.info("POST /subscribe : request : {}" , request);
        UserSubscriptionResponse userSubscriptionResponse =
                alphaUFiegnClient
                        .subscribe(profileSubscriptionRequestDTO.toAuthRequest(request));

        Profile profile = profileRepository.save( new ProfileBuilder()
                .setUserId( userSubscriptionResponse.getId())
                .setUserName( userSubscriptionResponse.getUserName())
                .setUserType( userSubscriptionResponse.getUserType())
                .setEmail( request.getEmail())
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setBirthDay(request.getBirthDay())
                .setOrganisation(request.getOrganisation())
                .build()
        );
        return new ResponseEntity<>( profile ,HttpStatus.ACCEPTED);
    }
}
