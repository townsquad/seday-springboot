package io.townsq.es.day.springboot.repository;

import io.townsq.es.day.springboot.domain.User;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Collection<User> findAllByLastName(String lastName);
    Collection<User> findAll();
}
