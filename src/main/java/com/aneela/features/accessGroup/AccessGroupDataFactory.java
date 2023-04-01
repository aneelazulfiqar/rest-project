package com.aneela.features.accessGroup;

import com.github.javafaker.Faker;

public class AccessGroupDataFactory {

    private static final Faker faker = new Faker();

    public static String customer_reference = faker.name().fullName();
}
