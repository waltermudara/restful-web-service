package com.in28minutes.rest.webservice.restfulwebservice.user;

import com.in28minutes.rest.webservice.restfulwebservice.exception.CustomUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    UserDaoService service;

    @GetMapping("/hello-world-international")
    public String halloWorldInternational(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
            return messageSource.getMessage("good.morning.message",null, locale);
        }




    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        User oneUser = service.findOneUser(id);
        if (oneUser==null){
            throw new CustomUserNotFoundException("id-"+ id);
        }

        return oneUser;
    }
    @DeleteMapping("/users/{id}")
    public User deleteById(@PathVariable int id){
        User user = service.deleteById(id);
        if (user==null){
            throw new CustomUserNotFoundException("id-"+ id);
        }

        return user;

    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
