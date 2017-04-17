package com.amiotisse.ubsunu.profile.model.transform;

import com.amiotisse.ubsunu.profile.model.UserToken;
import com.amiotisse.ubsunu.profile.model.UserType;
import com.amiotisse.ubsunu.profile.model.builder.UserTokenBuilder;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author himna
 * @since 4/17/2017.
 */
@Component
public class UserTokenDTO implements Function<DecodedJWT, UserToken> {
    @Override
    public UserToken apply(DecodedJWT decodedJWT) {
        return new UserTokenBuilder()
                .setId(decodedJWT.getClaim("id").asString())
                .setUserName(decodedJWT.getClaim("user_name").asString())
                .setUserType( UserType.fromString.get(decodedJWT.getClaim("user_type").asString()))
                .build();
    }
}
