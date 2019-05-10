package io.townsq.es.day.springboot.service;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.exception.HttpStatusException;
import org.springframework.http.HttpStatus;

public class UserService {

    public User getUserByEmail(String email) {
        User user = new User("tony.stark@townsq.io", "Tony", "Stark");

        if (user.getEmail().equals(email)) {
            return user;
        }
        throw new HttpStatusException("User not found", HttpStatus.NOT_FOUND);
    }

}
