package io.townsq.es.day.springboot;

import io.restassured.RestAssured;
import io.townsq.es.day.springboot.domain.User;
import java.time.LocalDate;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ApplicationTests {

    @Before
    public void setup() {
        RestAssured.get("http://localhost:8080");
    }

    @Test
    public void basicCrud() {
        User user = new User();

        user.setEmail("peter.parker@townsq.io");
        user.setFirstName("Peter");
        user.setLastName("Parker");
        user.setBirthDate(LocalDate.parse("2000-08-27"));

        Integer id = RestAssured
                .given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response()
                .path("id");

        RestAssured
                .given()
                .pathParam("userId", id)
                .when()
                .get("/users/{userId}")
                .then()
                .statusCode(200)
                .log().body()
                .body("email", Matchers.equalTo("peter.parker@townsq.io"))
                .body("birthDate", Matchers.equalTo("2000-08-27"));

        user.setBirthDate(LocalDate.parse("2001-08-27"));

        RestAssured
                .given()
                .contentType("application/json")
                .body(user)
                .pathParam("userId", id)
                .when()
                .put("/users/{userId}")
                .then()
                .statusCode(200)
                .body("birthDate", Matchers.equalTo("2001-08-27"));

        RestAssured
                .given()
                .pathParam("userId", id)
                .when()
                .delete("/users/{userId}")
                .then()
                .statusCode(204);

    }

}
