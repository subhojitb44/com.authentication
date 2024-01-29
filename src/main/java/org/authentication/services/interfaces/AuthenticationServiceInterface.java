package org.authentication.services.interfaces;

import org.authentication.entities.AppUser;
import org.authentication.services.type.auth.TokenRequestResponse;
import org.authentication.services.type.auth.AuthenticationRequestDto;
import org.authentication.services.type.auth.RegisterRequestDto;

public interface AuthenticationServiceInterface {
    TokenRequestResponse register(RegisterRequestDto request);
    Object authenticate(AuthenticationRequestDto request);
    public AppUser validateToken(String token);
    boolean logout(String token);
}