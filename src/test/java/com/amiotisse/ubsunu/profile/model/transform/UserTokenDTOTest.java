package com.amiotisse.ubsunu.profile.model.transform;

import com.amiotisse.ubsunu.profile.model.UserToken;
import com.amiotisse.ubsunu.profile.model.UserType;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author himna
 * @since 4/30/2017.
 */
public class UserTokenDTOTest {
    @Test
    public void apply() throws Exception {
        DecodedJWT jwt = mock(DecodedJWT.class);

        Claim idClaim = mock(Claim.class);
        when(idClaim.asString()).thenReturn("my_id");
        when(jwt.getClaim("id")).thenReturn(idClaim);

        Claim userNameClaim = mock(Claim.class);
        when(userNameClaim.asString()).thenReturn("my_userName");
        when(jwt.getClaim("user_name")).thenReturn(userNameClaim);

        Claim userTypeClaim = mock(Claim.class);
        when(userTypeClaim.asString()).thenReturn("teacher");
        when(jwt.getClaim("userType")).thenReturn(userTypeClaim);

        UserTokenDTO dto = new UserTokenDTO();
        UserToken token = dto.apply(jwt);

        assertEquals("my_id" , token.getId());
        assertEquals("my_userName" , token.getUserName());
        assertEquals(UserType.teacher, token.getUserType());

    }

}