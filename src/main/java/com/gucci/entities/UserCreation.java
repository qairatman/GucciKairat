package com.gucci.entities;

import com.gucci.data.FakeData;
import com.gucci.enums.Countries;

public class UserCreation {
   static FakeData fakeData = new FakeData();
    public static User createUser(){
        return new User(
                fakeData.name(),
                fakeData.email(),
                fakeData.firstOrSecond(),
                fakeData.password(),
                fakeData.DofB(),
                fakeData.name(),
                fakeData.name(),
                fakeData.lastName(),
                fakeData.company(),
                fakeData.address(),
                Countries.AUSTRALIA,
                fakeData.state(),
                fakeData.city(),
                fakeData.zipcode(),
                fakeData.phoneNumber()
        );
    }
}
