package com.amiotisse.ubsunu.profile.model.transform;

import com.amiotisse.ubsunu.profile.model.ProfileSubscriptionRequest;
import com.himnabil.alphau.client.model.AuthRequest;
import com.himnabil.alphau.client.model.builder.AuthRequestBuilder;

/**
 * @author himna
 * @since 4/23/2017.
 */
public class ProfileSubscriptionRequestDTO {

    private String appName;

    public ProfileSubscriptionRequestDTO (String appName){
        this.appName = appName ;
    }

    public AuthRequest toAuthRequest (ProfileSubscriptionRequest profileSubscriptionRequest){
        return new AuthRequestBuilder()
                .setAppName( appName )
                .setUserName( profileSubscriptionRequest.getUserName())
                .setPassword( profileSubscriptionRequest.getPassword())
                .setUserType( profileSubscriptionRequest.getUserType())
                .build();
    }
}
