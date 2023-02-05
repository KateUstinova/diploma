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
        cardPage.fullField(card);
        cardPage.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getPaymentApprovedStatus());
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedField();
        creditPage.fullField(card);
        creditPage.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getCreditApprovedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.declinedField();
        cardPage.fullField(card);
        cardPage.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getPaymentDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.declinedField();
        creditPage.fullField(card);
        creditPage.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getCreditDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        cardPage.fullField(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        creditPage.fullField(card);
        creditPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        cardPage.fullField(card);
        cardPage.monthError("Неверно указан срок действия карты");
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        creditPage.fullField(card);
        creditPage.monthError("Неверно указан срок действия карты");
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        cardPage.fullField(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        creditPage.fullField(card);
        creditPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        cardPage.fullField(card);
        cardPage.yearError("Истёк срок действия карты");
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        creditPage.fullField(card);
        creditPage.yearError("Истёк срок действия карты");
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        cardPage.fullField(card);
        cardPage.cvcError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        creditPage.fullField(card);
        creditPage.cvcError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        cardPage.fullField(card);
        cardPage.monthError("Неверно указан срок действия карты");
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        creditPage.fullField(card);
        creditPage.monthError("Неверно указан срок действия карты");
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        cardPage.fullField(card);
        cardPage.cvcError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        creditPage.fullField(card);
        creditPage.cvcError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.shortCard();
        cardPage.fullField(card);
        cardPage.cardNumberError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.shortCard();
        creditPage.fullField(card);
        creditPage.cardNumberError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        cardPage.fullField(card);
        cardPage.ownerError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        creditPage.fullField(card);
        creditPage.ownerError("Неверный формат");
    }

//пустые значения
    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyCardField();
        cardPage.fullField(card);
        cardPage.cardNumberError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyMonthField();
        cardPage.fullField(card);
        cardPage.monthError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyYearField();
        cardPage.fullField(card);
        cardPage.yearError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyOwnerField();
        cardPage.fullField(card);
        cardPage.ownerError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyCvcField();
        cardPage.fullField(card);
        cardPage.cvcError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var cardPage = mainPage.payToButton();
        var card = DataHelp.emptyFields();
        cardPage.fullField(card);
        cardPage.cardNumberError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyCardField();
        creditPage.fullField(card);
        creditPage.cardNumberError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyMonthField();
        creditPage.fullField(card);
        creditPage.monthError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyYearField();
        creditPage.fullField(card);
        creditPage.yearError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyOwnerField();
        creditPage.fullField(card);
        creditPage.ownerError("Поле обязательно для заполнения");
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyCvcField();
        creditPage.fullField(card);
        creditPage.cvcError("Неверный формат");
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var creditPage = mainPage.payInCreditToButton();
        var card = DataHelp.emptyFields();
        creditPage.fullField(card);
        creditPage.cardNumberError("Неверный формат");
        creditPage.monthError("Неверный формат");
        creditPage.yearError("Неверный формат");
        creditPage.ownerError("Поле обязательно для заполнения");
        creditPage.cvcError("Неверный формат");
    }
}
