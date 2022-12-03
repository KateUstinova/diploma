package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import ru.netology.data.DataHelp;
import ru.netology.data.SqlHelp;
import ru.netology.page.CardPage;
import static com.codeborne.selenide.Selenide.open;

public class Tests {


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        CardPage cardPage = new CardPage();
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    public void del() {
        SqlHelp.cleanDatabase();
    }

    @Mock
    CardPage cardPage;
    @Test
    public void shouldFillFormWithApprovedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedField();
        cardPage.buy(card);
        cardPage.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getPaymentApprovedStatus());
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedField();
        cardPage.buy(card);
        cardPage.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getCreditApprovedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.declinedField();
        cardPage.buy(card);
        cardPage.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getPaymentDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.declinedField();
        cardPage.buy(card);
        cardPage.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getCreditDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndWrongCvc();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.shortCard();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.shortCard();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        cardPage.buy(card);
        cardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        cardPage.buy(card);
        cardPage.ownerError();
    }

//пустые значения
    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.emptyCardField();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.emptyMonthField();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.emptyYearField();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.emptyOwnerField();
        cardPage.buy(card);
        cardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.emptyCvcField();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payToButton();
        var card = DataHelp.emptyFields();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyCardField();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyMonthField();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyYearField();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyOwnerField();
        cardPage.buy(card);
        cardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyCvcField();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
        var url = open("http://localhost:8080", CardPage.class);
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyFields();
        cardPage.buy(card);
        cardPage.cardNumberError();
        cardPage.monthError();
        cardPage.yearError();
        cardPage.ownerError();
        cardPage.cvcError();
    }
}
