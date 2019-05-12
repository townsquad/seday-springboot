package io.townsq.es.day.springboot.domain;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private final String email;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public User(String email, String firstName, String lastName, LocalDate birthDate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
