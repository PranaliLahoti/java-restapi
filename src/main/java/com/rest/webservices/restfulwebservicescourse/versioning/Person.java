package com.rest.webservices.restfulwebservicescourse.versioning;

public class Person {
    private String Name;

    public Person(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Person [Name=" + Name + "]";
    }
    
}
