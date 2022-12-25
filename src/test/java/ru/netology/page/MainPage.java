package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.model.CreditModel;
import ru.netology.model.PaymentModel;

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