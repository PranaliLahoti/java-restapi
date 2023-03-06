package com.rest.webservices.restfulwebservicescourse.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;
    static{
        users.add(new User(++userCount, "Pranali", LocalDate.now().minusYears(20) ));
        users.add(new User(++userCount, "Prajval", LocalDate.now().minusYears(18) ));
        users.add(new User(++userCount, "Priyanka", LocalDate.now().minusYears(25) ));
    }

    public List<User> findAll(){
        return users;
    }
    public User findOne(int id){
        Predicate<? super User> Predicate = user -> user.getId().equals(id);
        return users.stream().filter(Predicate).findFirst().orElse(null);
    }

    public void deleteUser(int id){
        Predicate<? super User> Predicate = user -> user.getId().equals(id);
        users.removeIf(Predicate);
    }

    public User saveUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
