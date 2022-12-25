package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelp;
import ru.netology.data.SqlHelp;
import ru.netology.page.CardPage;
import ru.netology.page.MainPage;

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

        var card = DataHelp.approvedField();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getPaymentApprovedStatus());
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedField();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getCreditApprovedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.declinedField();
        var page = new CardPage();
        page.fullField(card);
        page.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getPaymentDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.declinedField();
        var page = new CardPage();
        page.fullField(card);
        page.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getCreditDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        var page = new CardPage();
        page.fullField(card);
        page.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.shortCard();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.shortCard();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

//пустые значения
    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.emptyCardField();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.emptyMonthField();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.emptyYearField();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.emptyOwnerField();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.emptyCvcField();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payToButton();
        var card = DataHelp.emptyFields();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.emptyCardField();
        var page = new CardPage();
        page.fullField(card);
        page.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.emptyMonthField();
        var page = new CardPage();
        page.fullField(card);
        page.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.emptyYearField();
        var page = new CardPage();
        page.fullField(card);
        page.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.emptyOwnerField();
        var page = new CardPage();
        page.fullField(card);
        page.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
        var card = DataHelp.emptyCvcField();
        var page = new CardPage();
        page.fullField(card);
        page.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        var model = new MainPage();
        model.payInCreditToButton();
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
