package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.model.CreditModel;
import ru.netology.model.PaymentModel;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement payButton = $x("//span[text() = 'Купить']");
    private SelenideElement payInCreditButton = $x("//span[text() = 'Купить в кредит']");

    public CardPage payToButton() {
        payButton.click();
        return new CardPage();
    }

    public CreditPage payInCreditToButton() {
        payInCreditButton.click();
        return new CreditPage();
    }
}