package com.aneela.common.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:authorization.properties"})
public interface AuthorizationConfig extends Config {

    //Tokens
    @Key("authorization")
    String getAuthorizationToken();
    @Key("username")
    String getUsername();
    @Key("password")
    String getPassword();
}
