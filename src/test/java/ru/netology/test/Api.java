package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.ApiHelp;
import ru.netology.data.DataHelp;
import ru.netology.data.SqlHelp;

import static org.junit.jupiter.api.Assertions.assertTrue;


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
        val approvedCardForPayment = DataHelp.approvedField();
        final String response = ApiHelp.fillPaymentCard(approvedCardForPayment);
        assertTrue(response.contains("APPROVED"), "Is true when status is approved");
    }
    @Test
    public void shouldBeRestForDeclinedCard() {
        val declinedCardForPayment = DataHelp.declinedField();
        final String response = ApiHelp.fillPaymentCard(declinedCardForPayment);
        assertTrue(response.contains("DECLINED"), "Is true when status is declined");
    }

    @Test
    public void shouldBeNotRestForRandomCard() {
        val randomCardForPayment = DataHelp.randomField();
        final String response = ApiHelp.fillPaymentCard(randomCardForPayment);
        assertTrue(response.contains("400 Bad Request"), "Is true when status is 400 Bad Request");
    }

    @Test
    public void shouldBeNotRestForEmptyCard() {
        val emptyCardForPayment = DataHelp.emptyCardField();
        final String response = ApiHelp.fillPaymentCard(emptyCardForPayment);
        assertTrue(response.contains("400 Bad Request"), "Is true when status is 400 Bad Request");
    }

}
