package com.aneela.features.sites;

import com.github.javafaker.Faker;

import java.util.UUID;

public class SitesDataFactory {
    private static final Faker faker = new Faker();

    public static String customer_reference = faker.name().firstName();
    public static final String SITE_COUNTRY_CODE = "NL";
    public static final UUID OWNER_ID = UUID.fromString("a8dba465-2054-4647-a526-a4f2cf29671f");
    public static final String TIME_ZONE = "Europe/Amsterdam";
    public static final String NEXT_PAGE_LINK = "https://clp-accept-user.saltoks.com/v1.1/sites";
}
