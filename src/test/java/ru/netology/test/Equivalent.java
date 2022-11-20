package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;

public class Equivalent {

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
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedField();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.declinedField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithRandomCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.randomField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithRandomFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.randomField();
        CardPage.fullField(cardInfo);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndNextMonth();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndNextMonth();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndPastMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndPastMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndNextYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndNextYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndPastYear();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndPastYear();
        CardPage.fullField(cardInfo);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndWrongCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndWrongCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndZeroMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndZeroMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithThirteenthMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndThirteenthMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithThirteenthMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndThirteenthMonth();
        CardPage.fullField(cardInfo);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndZeroCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndZeroCvc();
        CardPage.fullField(cardInfo);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.shortCard();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.shortCard();
        CardPage.fullField(cardInfo);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndRussiaName();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndRussiaName();
        CardPage.fullField(cardInfo);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithMoreThanFiveYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var cardInfo = DataHelp.approvedFieldAndMoreThanFiveYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithMoreThanFiveYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var cardInfo = DataHelp.approvedFieldAndMoreThanFiveYear();
        CardPage.fullField(cardInfo);
        CardPage.successfulWay();
    }


}
