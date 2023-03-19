package com.example.demo.business.cases;

import com.example.demo.domain.AccessToken;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
