package com.example.modir.common.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.jwk.RSAKey;

import java.io.InputStream;
import java.net.URL;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

//Supabase 또는 다른 인증 서버의 JWK 엔드포인트(예: /.well-known/jwks.json)에서 RSA 공개키를 가져옴.
public class JwkUtil {

    public static PublicKey getPublicKeyFromJwk(String jwkUrl) throws Exception {
        InputStream is = new URL(jwkUrl).openStream();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jwkJson = mapper.readValue(is, Map.class);

        List<Map<String, Object>> keys = (List<Map<String, Object>>) jwkJson.get("keys");
        if (keys.isEmpty()) {
            throw new Exception("JWK 키 목록이 비어있습니다.");
        }

        Map<String, Object> firstKey = keys.get(0);

        RSAKey rsaKey = RSAKey.parse(firstKey);
        return rsaKey.toRSAPublicKey();
    }
}
