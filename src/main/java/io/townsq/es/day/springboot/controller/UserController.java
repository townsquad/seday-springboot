package io.townsq.es.day.springboot.controller;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController() {
        this.service = new UserService();
    }

    @GetMapping
    public User getUserByEmail(@RequestParam String email) {
        return service.getUserByEmail(email);
    }

}
