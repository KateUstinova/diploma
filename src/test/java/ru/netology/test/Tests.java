package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.data.SqlHelp;
import ru.netology.page.MainPage;
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
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedField();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getPaymentApprovedStatus());
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedField();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getCreditApprovedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.declinedField();
        var page = new CardPage();
        page.fullField(card);
        page.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getPaymentDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.declinedField();
        var page = new CardPage();
        page.fullField(card);
        page.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getCreditDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.shortCard();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.shortCard();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

//пустые значения
    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyCardField();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyMonthField();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyYearField();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyOwnerField();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyCvcField();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyFields();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyCardField();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyMonthField();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyYearField();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyOwnerField();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyCvcField();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyFields();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
        page.monthError();
        page.yearError();
        page.ownerError();
        page.cvcError();
    }
}
