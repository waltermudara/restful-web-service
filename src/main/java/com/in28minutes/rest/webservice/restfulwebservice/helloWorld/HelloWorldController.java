package com.in28minutes.rest.webservice.restfulwebservice.helloWorld;


import com.in28minutes.rest.webservice.restfulwebservice.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET, path="/hello-world")

    public String helloWorld(){
        return "hello world";
    }
    @RequestMapping(method = RequestMethod.GET, path="/hello-world-bean")

    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world");
    }
    @RequestMapping(method = RequestMethod.GET, path="/hello-world-bean/path-varriable/{name}")

    public HelloWorldBean pathVarriable(@PathVariable String name){
        return new HelloWorldBean( String.format("Hello World,%s", name));
    }
}
