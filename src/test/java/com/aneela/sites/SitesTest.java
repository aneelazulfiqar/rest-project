package com.aneela.sites;

import com.aneela.features.sites.SitesClient;
import com.aneela.features.sites.SitesDataFactory;
import com.aneela.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import com.aneela.features.authorization.AuthorizationDataFactory;
import com.aneela.generated.model.ManagedSiteResponse;
import com.aneela.generated.model.SiteResponse;
import com.aneela.generated.model.SiteResponsePagedResponse;
import com.aneela.generated.model.UserSummaryResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SitesTest extends BaseTest {

    @Test(groups = {"smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("Gets the list of sites the current user can view")
    @Description("GET/v1.1/sites - verify endpoint for getting sites of current user")
    public void verifySites() {
        SiteResponsePagedResponse site = SitesClient.getSites();
        SiteResponse firstItem = SitesClient.firstSiteHavingValidSubscription(site);

        softAssert.assertFalse(site.getItems().get().isEmpty(), "Items list is empty");
        softAssert.assertNotNull(firstItem.getId());
        softAssert.assertTrue(firstItem.getSubscriptionValid());
        softAssert.assertTrue(site.getNextPageLink().toString().contains(SitesDataFactory.NEXT_PAGE_LINK));
    }

    @Test(groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Story("Gets a single site")
    @Description("GET/v1.1/sites/{id} - verify site by siteId for current user")
    public void verifyGetSiteById() {
        SiteResponsePagedResponse siteResponse = SitesClient.getSites();
        String siteId = SitesClient.getSiteId(siteResponse);
        ManagedSiteResponse siteDetail = SitesClient.getSiteById(siteId);
        UserSummaryResponse siteOwner = siteDetail.getOwner();

        softAssert.assertNotNull(siteDetail.getId());
        softAssert.assertEquals(siteDetail.getCountryCode().get(), SitesDataFactory.SITE_COUNTRY_CODE);
        softAssert.assertEquals(siteOwner.getEmail().get(), AuthorizationDataFactory.USERNAME);
        softAssert.assertTrue(siteOwner.getHasProfile());

    }

    @Test(groups = {"regression"})
    @Severity(SeverityLevel.MINOR)
    @Story("Updates a site")
    @Description("PATCH/v1.1/sites/{id} - verify updating customer reference}")
    public void verifySiteUpdate() {
        SiteResponsePagedResponse siteResponse = SitesClient.getSites();
        String siteId = SitesClient.getSiteId(siteResponse);

        SiteResponse updatedSiteDetails = SitesClient.patchSiteById(siteId);
        String updatedCustomerReference = updatedSiteDetails.getCustomerReference().toString();

        ManagedSiteResponse siteDetail = SitesClient.getSiteById(siteId);
        String customerReference = siteDetail.getCustomerReference().toString();

        Assert.assertEquals(updatedCustomerReference, customerReference);
    }
}
