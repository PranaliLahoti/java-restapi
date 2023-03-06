package com.rest.webservices.restfulwebservicescourse.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restfulwebservicescourse.user.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
