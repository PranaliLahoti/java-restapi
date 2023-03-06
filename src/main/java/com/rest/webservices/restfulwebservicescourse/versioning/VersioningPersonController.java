package com.rest.webservices.restfulwebservicescourse.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    
    @GetMapping(path = "/v1/person")
    public Person getPerson(){
        return new Person("Pranali Lahoti");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionPerson(){
        return new PersonV2("Pranali","Lahoti");
    }

    @GetMapping(path = "/person", params = "version=1")
    public Person getPersonByVersion(){
        return new Person("Pranali Lahoti");
    }

    @GetMapping(path = "/person", headers  = "X-API-VERSION=1")
    public Person getPersonByVersionbyHeader(){
        return new Person("Pranali Lahoti");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionPersonRequest(){
        return new PersonV2("Pranali","Lahoti");
    }
}
