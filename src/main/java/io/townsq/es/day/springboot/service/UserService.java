package io.townsq.es.day.springboot.service;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.exception.HttpStatusException;
import io.townsq.es.day.springboot.repository.UserRepository;
import java.time.Month;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User getUserByEmail(String email) {
        return repository
                .findByEmail(email)
                .orElseThrow(() -> new HttpStatusException("User not found", HttpStatus.NOT_FOUND));
    }

    public Collection<User> listUserByLastName(String lastName) {
        return repository.findAllByLastName(lastName);
    }

    public Collection<String> listEmailByUserBirthdayMonth(Month month) {
        return repository
                .findAll()
                .stream()
                .filter(user -> user.getBirthDate().getMonth() == month)
                .map(User::getEmail)
                .collect(Collectors.toList());

    }

    public Collection<User> listAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new HttpStatusException("User not found", HttpStatus.NOT_FOUND));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Integer userId, User user) {
        String email = repository.findById(userId)
                .map(User::getEmail)
                .orElseThrow(() -> new HttpStatusException("User not found", HttpStatus.NOT_FOUND));

        user.setId(userId);
        user.setEmail(email);

        return repository.save(user);
    }

    public void deleteUserById(Integer userId) {
        repository.deleteById(userId);
    }

}
