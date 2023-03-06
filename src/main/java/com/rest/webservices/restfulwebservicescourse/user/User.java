package com.rest.webservices.restfulwebservicescourse.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min = 2,message = "Name should always have 2 characters")
    // @JsonProperty("user_name")
    private String name;

    @Past(message = "Birth data should be in past")
    // @JsonProperty("birth_date")
    private LocalDate birthdate;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
    protected User(){

    }
    public User(Integer id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
