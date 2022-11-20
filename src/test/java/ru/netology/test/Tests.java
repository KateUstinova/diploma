package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;

public class Tests {

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
        var card = DataHelp.approvedField();
        CardPage.fullField(card);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedField();
        CardPage.fullField(card);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.declinedField();
        CardPage.fullField(card);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.declinedField();
        CardPage.fullField(card);
        CardPage.unSuccessfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        CardPage.fullField(card);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        CardPage.fullField(card);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        CardPage.fullField(card);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        CardPage.fullField(card);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        CardPage.fullField(card);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        CardPage.fullField(card);
        CardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        CardPage.fullField(card);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        CardPage.fullField(card);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        CardPage.fullField(card);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        CardPage.fullField(card);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        CardPage.fullField(card);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        CardPage.fullField(card);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        CardPage.fullField(card);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        CardPage.fullField(card);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.shortCard();
        CardPage.fullField(card);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.shortCard();
        CardPage.fullField(card);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        CardPage.fullField(card);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        CardPage.fullField(card);
        CardPage.ownerError();
    }

//пустые значения
    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.emptyCardField();
        CardPage.fullField(card);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.emptyMonthField();
        CardPage.fullField(card);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.emptyYearField();
        CardPage.fullField(card);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.emptyOwnerField();
        CardPage.fullField(card);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.emptyCvcField();
        CardPage.fullField(card);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payToButton();
        var card = DataHelp.emptyFields();
        CardPage.fullField(card);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.emptyCardField();
        CardPage.fullField(card);
        CardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.emptyMonthField();
        CardPage.fullField(card);
        CardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.emptyYearField();
        CardPage.fullField(card);
        CardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.emptyOwnerField();
        CardPage.fullField(card);
        CardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.emptyCvcField();
        CardPage.fullField(card);
        CardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        CardPage.payInCreditToButton();
        var card = DataHelp.emptyFields();
        CardPage.fullField(card);
        CardPage.cardNumberError();
        CardPage.monthError();
        CardPage.yearError();
        CardPage.ownerError();
        CardPage.cvcError();
    }
}
