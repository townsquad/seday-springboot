package io.townsq.es.day.springboot.controller;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.service.UserService;
import java.time.Month;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/emails/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @GetMapping("/emails")
    public Collection<String> listUserEmailsByLastName(@RequestParam Month birthdayMonth) {
        return service.listEmailByUserBirthdayMonth(birthdayMonth);
    }

    @GetMapping
    public Collection<User> listUserByLastName(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return service.listAllUsers();
        }
        return service.listUserByLastName(lastName);
    }

}
