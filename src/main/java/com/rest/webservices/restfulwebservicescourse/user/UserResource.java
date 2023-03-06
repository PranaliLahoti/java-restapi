package com.rest.webservices.restfulwebservicescourse.user;

import java.net.URI;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {


    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> retriveAllUser(){
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retriveUserDetail(@PathVariable int id){
        User user =  service.findOne(id);
        if(user == null)throw new UserNotFoundException("id: "+id);

        EntityModel<User> entity = EntityModel.of(user); 
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());

        entity.add(link.withRel("all-users"));
        
        return entity;
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable int id){
        service.deleteUser(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User newUser = service.saveUser(user);
        URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(Location).build();
    }
    
}
