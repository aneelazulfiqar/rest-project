package com.aneela.common.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {
    public static AuthorizationConfig getAuthorizationConfig() {
        return ConfigCache.getOrCreate(AuthorizationConfig.class);
    }

    public static UriConfig getUriConfig() {
        return ConfigCache.getOrCreate(UriConfig.class);
    }
}

