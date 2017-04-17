package com.amiotisse.ubsunu.profile;


import com.amiotisse.ubsunu.profile.model.UserToken;
import com.amiotisse.ubsunu.profile.model.transform.UserTokenDTO;
import com.himnabil.alphau.client.AlphaUFiegnClient;
import com.himnabil.alphau.client.filter.AlphaUClientFilter;
import com.himnabil.alphau.client.filter.utils.KeyProvider;
import com.himnabil.alphau.client.filter.utils.KeyProviderImpl;
import com.himnabil.alphau.client.filter.utils.TokenDecoder;
import com.himnabil.alphau.client.filter.utils.TokenDecoderJWTImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @author himna
 * @since 4/16/2017.
 */
@Configuration
@EnableFeignClients(clients = {AlphaUFiegnClient.class})
@ComponentScan(basePackageClasses = AlphaUFiegnClient.class)
public class FilterConfiguration
{

    @Bean
    KeyProvider keyProvider (AlphaUFiegnClient alphaUClient){
        return new KeyProviderImpl(alphaUClient);
    }
    @Bean
    TokenDecoder<?> tokenDecoder(KeyProvider keyProvider){
        return new TokenDecoderJWTImpl(keyProvider);
    }


    @Bean
    AlphaUClientFilter alphaUClientFilter(TokenDecoder<?> tokenDecoder, UserTokenDTO claimsTransformer){
        return new AlphaUClientFilter.Builder()
                .setTokenDecoder(tokenDecoder)
                .setClaimsTransformer(claimsTransformer)
                .build();
    }

    @Bean
    public FilterRegistrationBean alphaUClientFilterRegistrationBean( AlphaUClientFilter alphaUClientFilter){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter( alphaUClientFilter );
        registrationBean.addUrlPatterns("/profile/*");
        return registrationBean ;
    }
}
