package io.townsq.es.day.springboot.service;

import static org.assertj.core.api.BDDAssertions.then;

import io.townsq.es.day.springboot.domain.User;
import org.junit.Test;

public class UserServiceTest {

    private final UserService service = new UserService();

    @Test
    public void retrieveUserByEmail() {
        String email = "tony.stark@townsq.io";

        User stark = service.getUserByEmail(email);

        then(stark.getEmail()).isEqualTo(email);
    }

}
