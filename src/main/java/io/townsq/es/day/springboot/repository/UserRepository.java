package io.townsq.es.day.springboot.repository;

import io.townsq.es.day.springboot.domain.User;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Collection<User> users = Arrays.asList(
            new User("tony.stark@townsq.io", "Tony", "Stark", LocalDate.parse("1970-05-29")),
            new User("steve.rogers@townsq.io", "Steve", "Rogers", LocalDate.parse("1018-07-04")),
            new User("bruce.banner@townsq.io", "Bruce", "Banner", LocalDate.parse("1969-12-18")),
            new User("thor.odinson@townsq.io", "Thor", "Odinson", LocalDate.parse("1000-01-01")),
            new User("clinton.barton@townsq.io", "Clinton", "Barton", LocalDate.parse("1971-01-07")),
            new User("natasha.romanoff@townsq.io", "Natasha", "Romanoff", LocalDate.parse("1984-11-22")));

    public Optional<User> getByEmail(String email) {
        return users
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public Stream<User> listUserByLastName(String lastName) {
        return users
                .stream()
                .filter(user -> user.getLastName().equals(lastName));
    }

    public Stream<User> listEmailByUserBirthdayMonth(Month month) {
        return users
                .stream()
                .filter(user -> user.getBirthDate().getMonth() == month);
    }

}
