package com.aneela.features.accessGroup;

import io.restassured.specification.RequestSpecification;
import com.aneela.common.util.CommonSpec;
import com.aneela.generated.model.PostAccessGroupRequest;

public class AccessGroupSpec extends CommonSpec {
    public static RequestSpecification createAccessGroup(String siteId) {
        return appRequestSpecification(String.format(configuration.accessGroupUri(),siteId),
                new PostAccessGroupRequest()
                        .customerReference(AccessGroupDataFactory.customer_reference));
    }

}
