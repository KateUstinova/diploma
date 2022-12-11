package ru.netology.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement payButton = $x("//span[text() = 'Купить']");
    private SelenideElement payInCreditButton = $x("//span[text() = 'Купить в кредит']");

    public PaymentModel payToButton() {
        payButton.click();
        return new PaymentModel();
    }

    public CreditModel payInCreditToButton() {
        payInCreditButton.click();
        return new CreditModel();
    }
}