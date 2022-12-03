package ru.netology.model;

import com.codeborne.selenide.SelenideElement;

import java.net.CacheRequest;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement buttonBuy = $x("//span[text() = 'Купить']");
    private SelenideElement buttonWithCredit = $x("//span[text() = 'Купить в кредит']");

    public PaymentModel cardPayment() {
        buttonBuy.click();
        return new PaymentModel();
    }

    public CreditModel creditPayment() {
        buttonWithCredit.click();
        return new CreditModel();
    }
}