package org.authentication.services.type.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder @Getter @Setter @ToString
public class TokenRequestResponse {
    private String token;
}