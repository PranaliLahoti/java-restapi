package com.rest.webservices.restfulwebservicescourse.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController{

    //either of this two method can be used
    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path="/hello-world")
    public String helloworld(){
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloworlduser(@PathVariable String name){
        return new HelloWorldBean("Hello World, "+name);
    }

    @GetMapping(path="/hello-world-internationalize")
    public String helloworlduser(){
        return "Hello World Interntionalize";
    }
}