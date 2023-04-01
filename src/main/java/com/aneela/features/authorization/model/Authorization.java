package com.aneela.features.authorization.model;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class Authorization {
    private String grant_type;
    private String scope;
    private String username;
    private String password;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", this.grant_type);
        map.put("scope", this.scope);
        map.put("username", this.username);
        map.put("password", this.password);
        return map;
    }
}
