package com.gucci.entities;

import com.gucci.enums.Countries;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User {
    String name;
    String email;
    String title;
    String password;
    String dataOfBirth;
    String firstName;
    String lastName;
    String company;
    String address;
    String address2;
    Countries countries;
    String state;
    String city;
    String zipcode;
    String mobileNumber;






}
