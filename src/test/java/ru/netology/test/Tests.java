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

    @BeforeEach
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        var url = open("http://localhost:8080", CardPage.class);

    }
    @AfterEach
    public void del() {
        SqlHelp.cleanDatabase();
    }

    @Mock
    CardPage cardPage;
    @Test
    public void shouldFillFormWithApprovedCardForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedField();
        cardPage.buy(card);
        cardPage.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getPaymentApprovedStatus());
    }

    @Test
    public void shouldFillFormWithApprovedCardForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedField();
        cardPage.buy(card);
        cardPage.successfulWay();
        Assertions.assertEquals("APPROVED", SqlHelp.getCreditApprovedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedCardForPayment() {
        cardPage.payToButton();
        var card = DataHelp.declinedField();
        cardPage.buy(card);
        cardPage.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getPaymentDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithDeclinedFieldForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.declinedField();
        cardPage.buy(card);
        cardPage.unSuccessfulWay();
        Assertions.assertEquals("DECLINED", SqlHelp.getCreditDeclinedStatus());
    }

    @Test
    public void shouldFillFormWithNextMonthForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextMonthForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextMonth();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastMonthForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithPastMonthForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithNextYearForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithNextYearForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndNextYear();
        cardPage.buy(card);
        cardPage.successfulWay();
    }

    @Test
    public void shouldFillFormWithPastYearForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithPastYearForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndPastYear();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithWrongCvcForPayment() {
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
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroMonthForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroMonth();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithZeroCvcForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndZeroCvc();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithShortCardForPayment() {
        cardPage.payToButton();
        var card = DataHelp.shortCard();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithShortCardForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.shortCard();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForPayment() {
        cardPage.payToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        cardPage.buy(card);
        cardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithRussiaNameForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.approvedFieldAndRussiaName();
        cardPage.buy(card);
        cardPage.ownerError();
    }

//пустые значения
    @Test
    public void shouldFillFormWithEmptyCardForPayment() {
        cardPage.payToButton();
        var card = DataHelp.emptyCardField();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForPayment() {
        cardPage.payToButton();
        var card = DataHelp.emptyMonthField();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForPayment() {
        cardPage.payToButton();
        var card = DataHelp.emptyYearField();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForPayment() {
        cardPage.payToButton();
        var card = DataHelp.emptyOwnerField();
        cardPage.buy(card);
        cardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForPayment() {
        cardPage.payToButton();
        var card = DataHelp.emptyCvcField();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForPayment() {
        cardPage.payToButton();
        var card = DataHelp.emptyFields();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyCardForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyCardField();
        cardPage.buy(card);
        cardPage.cardNumberError();
    }

    @Test
    public void shouldFillFormWithEmptyMonthForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyMonthField();
        cardPage.buy(card);
        cardPage.monthError();
    }

    @Test
    public void shouldFillFormWithEmptyYearForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyYearField();
        cardPage.buy(card);
        cardPage.yearError();
    }

    @Test
    public void shouldFillFormWithEmptyOwnerForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyOwnerField();
        cardPage.buy(card);
        cardPage.ownerError();
    }

    @Test
    public void shouldFillFormWithEmptyCvcForCredit() {
        cardPage.payInCreditToButton();
        var card = DataHelp.emptyCvcField();
        cardPage.buy(card);
        cardPage.cvcError();
    }

    @Test
    public void shouldFillFormWithEmptyFieldsForCredit() {
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
