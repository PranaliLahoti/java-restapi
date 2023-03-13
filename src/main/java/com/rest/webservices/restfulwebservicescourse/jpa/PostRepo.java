package com.rest.webservices.restfulwebservicescourse.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restfulwebservicescourse.user.Post;

public interface PostRepo extends JpaRepository<Post,Integer>{
    
}
