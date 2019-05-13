package io.townsq.es.day.springboot.service;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import io.townsq.es.day.springboot.domain.User;
import io.townsq.es.day.springboot.repository.UserRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserService service;

    @Test
    public void retrieveUserByEmail() {
        String email = "tony.stark@townsq.io";
        User tony = mock(User.class);

        given(tony.getEmail()).willReturn(email);
        given(repository.findByEmail(email)).willReturn(Optional.of(tony));

        User stark = service.getUserByEmail(email);

        then(stark.getEmail()).isEqualTo(email);
    }

    @Test
    public void listUsersByLastName() {
        User steve = mock(User.class);

        given(steve.getLastName()).willReturn("Rogers");
        given(repository.findAllByLastName("Rogers")).willReturn(Collections.singletonList(steve));

        Collection<User> users = service.listUserByLastName("Rogers");

        then(users).anyMatch(user -> user.getLastName().equals("Rogers"));
    }

    @Test
    public void listUserEmailsByBirthdayMonth() {
        User natasha = mock(User.class);
        User bruce = mock(User.class);

        given(natasha.getEmail()).willReturn("natasha.romanoff@townsq.io");
        given(natasha.getBirthDate()).willReturn(LocalDate.parse("1984-11-22"));
        given(bruce.getBirthDate()).willReturn(LocalDate.parse("1969-12-18"));

        given(repository.findAll()).willReturn(Arrays.asList(natasha, bruce));

        Collection<String> emails = service.listEmailByUserBirthdayMonth(Month.NOVEMBER);

        then(emails).anyMatch(email -> email.equals("natasha.romanoff@townsq.io"));
    }

}
