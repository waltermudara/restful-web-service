package com.in28minutes.rest.webservice.restfulwebservice.user;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private int userCount = 3;


    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(1, "Eve", new Date()));
        users.add(new User(1, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        if (user.getId()==null ) user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOneUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public User deleteById(int id) {
        Iterator<User>iterator = users.iterator();
        while (iterator.hasNext()){
            User user =iterator.next();
            if (user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}