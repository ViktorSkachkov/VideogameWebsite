package com.example.demo.business.cases;

import com.example.demo.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
