package io.townsq.es.day.springboot.service;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.exception.HttpStatusException;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.http.HttpStatus;

public class UserService {

    private final Collection<User> users = Arrays.asList(
            new User("tony.stark@townsq.io", "Tony", "Stark"),
            new User("steve.rogers@townsq.io", "Steve", "Rogers"),
            new User("bruce.banner@townsq.io", "Bruce", "Banner"),
            new User("thor.odinson@townsq.io", "Thor", "Odinson"),
            new User("clinton.barton@townsq.io", "Clinton", "Barton"),
            new User("natasha.romanoff@townsq.io", "Natasha", "Romanoff"));

    public User getUserByEmail(String email) {
        return users
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new HttpStatusException("User not found", HttpStatus.NOT_FOUND));
    }

}
