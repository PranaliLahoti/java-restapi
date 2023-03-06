package com.rest.webservices.restfulwebservicescourse.versioning;

public class PersonV2 {

    private String firstName;
    private String lastName;
    public PersonV2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    
}
