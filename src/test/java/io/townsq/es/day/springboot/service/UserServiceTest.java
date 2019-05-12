package io.townsq.es.day.springboot.service;

import static org.assertj.core.api.BDDAssertions.then;

import io.townsq.es.day.springboot.domain.User;
import java.time.Month;
import java.util.Collection;
import org.junit.Test;

public class UserServiceTest {

    private final UserService service = new UserService();

    @Test
    public void retrieveUserByEmail() {
        String email = "tony.stark@townsq.io";

        User stark = service.getUserByEmail(email);

        then(stark.getEmail()).isEqualTo(email);
    }

    @Test
    public void listUsersByLastName() {
        Collection<User> users = service.listUserByLastName("Rogers");

        then(users).anyMatch(user -> user.getLastName().equals("Rogers"));
    }

    @Test
    public void listUserEmailsByBirthdayMonth() {
        Collection<String> emails = service.listEmailByUserBirthdayMonth(Month.NOVEMBER);

        then(emails).anyMatch(email -> email.equals("natasha.romanoff@townsq.io"));
    }

}
