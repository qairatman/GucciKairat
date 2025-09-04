package com.gucci.data;

import net.datafaker.Faker;

import java.util.Date;

public class FakeData {
    net.datafaker.Faker faker = new Faker();

    public String name() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String email() {
        return faker.internet().emailAddress();
    }

    public String firstOrSecond() {
        return Integer.toString(faker.number().numberBetween(1, 2));
    }
    public String company() {
        return faker.company().name();
    }
    public String address(){
       return faker.address().streetAddress();
    }
    public String state(){
       return faker.address().stateAbbr();
    }
    public String password(){
       return faker.internet().password();
    }
    public String city(){
       return faker.address().city();
    }
    public String zipcode(){
       return faker.address().zipCode();
    }
    public String phoneNumber(){
       return faker.phoneNumber().phoneNumber();
    }

    public String DofB() {
        String day = Integer.toString(faker.number().numberBetween(1,30));
        String month = Integer.toString(faker.number().numberBetween(1,12));
        String year = Integer.toString(faker.number().numberBetween(1900,2021));

        return day+"-"+month+"-"+year;
    }
}
