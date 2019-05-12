package io.townsq.es.day.springboot.service;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.exception.HttpStatusException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;

public class UserService {

    private final Collection<User> users = Arrays.asList(
            new User("tony.stark@townsq.io", "Tony", "Stark", LocalDate.parse("1970-05-29")),
            new User("steve.rogers@townsq.io", "Steve", "Rogers", LocalDate.parse("1018-07-04")),
            new User("bruce.banner@townsq.io", "Bruce", "Banner", LocalDate.parse("1969-12-18")),
            new User("thor.odinson@townsq.io", "Thor", "Odinson", LocalDate.parse("1000-01-01")),
            new User("clinton.barton@townsq.io", "Clinton", "Barton", LocalDate.parse("1971-01-07")),
            new User("natasha.romanoff@townsq.io", "Natasha", "Romanoff", LocalDate.parse("1984-11-22")));

    public User getUserByEmail(String email) {
        return users
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new HttpStatusException("User not found", HttpStatus.NOT_FOUND));
    }

    public Collection<User> listUserByLastName(String lastName) {
        return users
                .stream()
                .filter(user -> user.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public Collection<String> listEmailByUserBirthdayMonth(Month month) {
        return users
                .stream()
                .filter(user -> user.getBirthDate().getMonth() == month)
                .map(user -> user.getEmail())
                .collect(Collectors.toList());

    }

}
