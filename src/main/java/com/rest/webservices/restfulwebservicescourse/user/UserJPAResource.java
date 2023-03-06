package com.rest.webservices.restfulwebservicescourse.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rest.webservices.restfulwebservicescourse.jpa.UserRepo;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {



    private UserRepo repo;

    public UserJPAResource(UserRepo repo){
        this.repo = repo;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> retriveAllUser(){
        return repo.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> retriveUserDetail(@PathVariable int id){
        Optional<User> user =  repo.findById(id);
        if(user.isEmpty())throw new UserNotFoundException("id: "+id);

        EntityModel<User> entity = EntityModel.of(user.get()); 
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());

        entity.add(link.withRel("all-users"));
        
        return entity;
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUserById(@PathVariable int id){
        repo.deleteById(id);
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User newUser = repo.save(user);
        URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(Location).build();
    }
    
}
