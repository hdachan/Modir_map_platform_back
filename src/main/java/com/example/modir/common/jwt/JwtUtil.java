package com.example.modir.common.jwt;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.RSASSAVerifier;

import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

///JWT의 RSA 서명을 RSAPublicKey로 검증.
public class JwtUtil {

    public static boolean validateJwtToken(String token, PublicKey publicKey) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            RSASSAVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);
            return jwsObject.verify(verifier);
        } catch (Exception e) {
            return false;
        }
    }
}

