package com.aneela.features.sites;

import com.aneela.common.util.CommonSpec;
import io.restassured.specification.RequestSpecification;
import com.aneela.generated.model.PatchSiteRequest;

public class SitesSpec extends CommonSpec {
    public static RequestSpecification getSitesDetail() {
        return appRequestSpecification(configuration.appSiteUri(), null);
    }

    public static RequestSpecification getSiteById(String siteId) {
        return appRequestSpecification(String.format(configuration.appSiteIdUri(), siteId), null);
    }

    public static RequestSpecification updateSiteById(String siteId) {
        return appRequestSpecification(String.format(configuration.appSiteIdUri(), siteId),
                new PatchSiteRequest()
                        .customerReference(SitesDataFactory.customer_reference)
                        .ownerId(SitesDataFactory.OWNER_ID)
                        .countryCode(SitesDataFactory.SITE_COUNTRY_CODE)
                        .timeZone(SitesDataFactory.TIME_ZONE));
    }
}
