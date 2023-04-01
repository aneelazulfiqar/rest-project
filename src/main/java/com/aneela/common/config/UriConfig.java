package com.aneela.common.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:url.properties"})
public interface UriConfig extends Config {

    //app URI
    @Key("api.app.authorization")
    String authorizationUri();
    @Key("api.app.sites")
    String appSiteUri();
    @Key("api.app.siteId")
    String appSiteIdUri();
    @Key("api.app.accessGroup")
    String accessGroupUri();
}
