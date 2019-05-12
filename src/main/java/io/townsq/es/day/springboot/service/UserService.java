package io.townsq.es.day.springboot.service;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.exception.HttpStatusException;
import io.townsq.es.day.springboot.repository.UserRepository;
import java.time.Month;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;

public class UserService {

    private final UserRepository repository = new UserRepository();

    public User getUserByEmail(String email) {
        return repository
                .getByEmail(email)
                .orElseThrow(() -> new HttpStatusException("User not found", HttpStatus.NOT_FOUND));
    }

    public Collection<User> listUserByLastName(String lastName) {
        return repository
                .listUserByLastName(lastName)
                .collect(Collectors.toList());
    }

    public Collection<String> listEmailByUserBirthdayMonth(Month month) {
        return repository
                .listEmailByUserBirthdayMonth(month)
                .map(user -> user.getEmail())
                .collect(Collectors.toList());

    }

}
