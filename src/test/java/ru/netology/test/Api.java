package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Api {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    public void shouldBeRestForApprovedCard() {
        String request = "{\n" +
                "    \"number\": \"4444 4444 4444 4441\",\n" +
                "    \"month\": \"10\",\n" +
                "    \"year\": \"25\",\n" +
                "    \"holder\": \"Ekaterina Ustinova\",\n" +
                "    \"cvc\": \"365\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(200).
                body("status", equalTo("APPROVED"));
    }

    @Test
    public void shouldBeRestForDeclinedCard() {
        String request = "{\n" +
                "    \"number\": \"4444 4444 4444 4442\",\n" +
                "    \"month\": \"10\",\n" +
                "    \"year\": \"25\",\n" +
                "    \"holder\": \"Ekaterina Ustinova\",\n" +
                "    \"cvc\": \"365\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(200).
                body("status", equalTo("DECLINED"));
    }

    @Test
    public void shouldBeNotRestForRandomCard() {
        String request = "{\n" +
                "    \"number\": \"2315 4610 4270 1254\",\n" +
                "    \"month\": \"10\",\n" +
                "    \"year\": \"25\",\n" +
                "    \"holder\": \"Ekaterina Ustinova\",\n" +
                "    \"cvc\": \"365\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(500).
                body("message", equalTo("400 Bad Request"));
    }

    @Test
    public void shouldBeNotRestForEmptyCard() {
        String request = "{\n" +
                "    \"number\": \"\",\n" +
                "    \"month\": \"\",\n" +
                "    \"year\": \"\",\n" +
                "    \"holder\": \"\",\n" +
                "    \"cvc\": \"\"\n" +
                "}";

        given().
                header("Content-Type", "application/json").
                body(request).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(500).
                body("message", equalTo("400 Bad Request"));
    }
}
