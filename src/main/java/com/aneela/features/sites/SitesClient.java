package com.aneela.features.sites;

import com.aneela.common.util.RestAssuredCrud;
import com.aneela.generated.model.ManagedSiteResponse;
import com.aneela.generated.model.SiteResponse;
import com.aneela.generated.model.SiteResponsePagedResponse;
import io.qameta.allure.Step;
import org.apache.http.HttpStatus;

import java.util.NoSuchElementException;


public class SitesClient extends RestAssuredCrud {

    @Step
    public static SiteResponsePagedResponse getSites() {
        return get(SitesSpec.getSitesDetail(), HttpStatus.SC_OK).as(SiteResponsePagedResponse.class);
    }

    @Step
    public static ManagedSiteResponse getSiteById(String siteId) {
        return get(SitesSpec.getSiteById(siteId), HttpStatus.SC_OK).as(ManagedSiteResponse.class);
    }

    @Step
    public static SiteResponse patchSiteById(String siteId) {
        return patch(SitesSpec.updateSiteById(siteId), HttpStatus.SC_OK).as(SiteResponse.class);
    }

    @Step
    public static SiteResponse firstSiteData(SiteResponsePagedResponse response) {
        return response.getItems()
                .get()
                .stream()
                .filter(SiteResponse::getSubscriptionValid)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item list is empty"));
    }

    @Step
    public static String getSiteId(SiteResponsePagedResponse response) {
        return firstSiteData(response).getId().toString();
    }
}
