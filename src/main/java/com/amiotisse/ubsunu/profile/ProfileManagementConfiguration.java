package com.amiotisse.ubsunu.profile;

import com.amiotisse.ubsunu.profile.controller.SubscribeController;
import com.amiotisse.ubsunu.profile.model.transform.ProfileSubscriptionRequestDTO;
import com.amiotisse.ubsunu.profile.repository.ProfileRepository;
import com.himnabil.alphau.client.AlphaUFiegnClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author himna
 * @since 4/23/2017.
 */
@Configuration
public class ProfileManagementConfiguration {

    String appName = "ubsunu";

    @Bean
    public ProfileSubscriptionRequestDTO profileSubscriptionRequestDTO(){
        return new ProfileSubscriptionRequestDTO(appName);
    }

    @Bean
    public SubscribeController subscribeController(
            ProfileSubscriptionRequestDTO profileSubscriptionRequestDTO,
            AlphaUFiegnClient alphaUFiegnClient,
            ProfileRepository profileRepository
    ){
        return new SubscribeController(
                profileSubscriptionRequestDTO ,
                alphaUFiegnClient ,
                profileRepository
        );
    }


}
