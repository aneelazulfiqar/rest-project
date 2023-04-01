package com.aneela.accessGroup;

import com.aneela.features.accessGroup.AccessGroupClient;
import com.aneela.features.accessGroup.AccessGroupDataFactory;
import com.aneela.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import com.aneela.features.sites.SitesClient;
import com.aneela.generated.model.AccessGroupResponse;
import com.aneela.generated.model.SiteResponsePagedResponse;
import org.testng.annotations.Test;

public class AccessGroupTest extends BaseTest {

    @Test(groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Story("Creates a access group")
    @Description("POST/v1.1/sites/{{siteId}}/access_groups - verify adding new group to site}")
    public void verifyAddingGroupAccess() {
        SiteResponsePagedResponse siteResponse = SitesClient.getSites();
        String siteId = SitesClient.getSiteId(siteResponse);

        AccessGroupResponse newAccessGroup = AccessGroupClient.postAccessGroup(siteId);

        String groupId = newAccessGroup.getId().toString();
        String referenceName = newAccessGroup.getCustomerReference().get();

        softAssert.assertNotNull(groupId);
        softAssert.assertNotNull(referenceName);
        softAssert.assertEquals(referenceName, AccessGroupDataFactory.customer_reference);
    }
}

