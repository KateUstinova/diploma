package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.data.SqlHelp;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetStatus {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    public void shouldFillFormWithApprovedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
        var expectedStatus = "APPROVED";
        var actualStatus = SqlHelp.getPaymentApprovedStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
        var expectedStatus = "DECLINED";
        var actualStatus = SqlHelp.getPaymentDeclinedStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();

        var expectedStatus = "APPROVED";
        var actualStatus = SqlHelp.getCreditApprovedStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void shouldFillFormWithDeclinedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
        var expectedStatus = "DECLINED";
        var actualStatus = SqlHelp.getCreditDeclinedStatus();
        assertEquals(expectedStatus, actualStatus);
    }

}







