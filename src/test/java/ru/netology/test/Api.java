package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.data.ApiHelp;

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

    @Mock
    ApiHelp apiHelp;


    @Test
    public void shouldBeRestForApprovedCard() {
        String cardInfoJson = apiHelp.createCardInfoJson("4444 4444 4444 4441");

        given().
                header("Content-Type", "application/json").
                body(cardInfoJson).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(200).
                body("status", equalTo("APPROVED"));
    }

    @Test
    public void shouldBeRestForDeclinedCard() {
        String cardInfoJson = apiHelp.createCardInfoJson("4444 4444 4444 4442");

        given().
                header("Content-Type", "application/json").
                body(cardInfoJson).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(200).
                body("status", equalTo("DECLINED"));
    }

    @Test
    public void shouldBeNotRestForRandomCard() {
        String cardInfoJson = apiHelp.createCardInfoJson("2315 4610 4270 1254");
        given().
                header("Content-Type", "application/json").
                body(cardInfoJson).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(500).
                body("message", equalTo("400 Bad Request"));
    }

    @Test
    public void shouldBeNotRestForEmptyCard() {
        String emptyCardInfoJson = apiHelp.getEmptyCardInfoJson();

        given().
                header("Content-Type", "application/json").
                body(emptyCardInfoJson).
                when().
                post("http://localhost:8080/api/v1/credit").
                then().
                statusCode(500).
                body("message", equalTo("400 Bad Request"));
    }
}
