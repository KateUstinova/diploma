package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelp;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private static SelenideElement numberOfCard = $x("//*[@placeholder='0000 0000 0000 0000']");
    private static SelenideElement month = $x("//*[@placeholder='08']");
    private static SelenideElement year = $x("//*[@placeholder='22']");
    private static ElementsCollection ownerSet = $$x("//*[@class='input__control']");
    private static SelenideElement owner = ownerSet.get(3);
    private static SelenideElement cvc = $x("//*[@placeholder='999']");
    private static ElementsCollection continueButtonSet = $$x("//*[@class='button__text']");
    private static SelenideElement continueButton = continueButtonSet.get(2);
    private static SelenideElement sucNote = $(byText("Операция одобрена Банком."));
    private static SelenideElement errNote = $(byText("Ошибка! Банк отказал в проведении операции."));

    private SelenideElement cardNumberErrorText = $x("//*[text()='Номер карты']/following-sibling::span[2]");
    private SelenideElement monthErrorText = $x("//*[text()='Месяц']/following-sibling::span[2]");
    private SelenideElement yearErrorText = $x("//*[text()='Год']/following-sibling::span[2]");
    private SelenideElement ownerErrorText = $x("//*[text()='Владелец']/following-sibling::span[2]");
    private SelenideElement cvvErrorText = $x("//*[text()='CVC/CVV']/following-sibling::span[2]");


    public void fullField(DataHelp.Card info) {
        numberOfCard.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        owner.setValue(info.getOwner());
        cvc.setValue(info.getCvc());
        continueButton.click();
    }

    public void successfulWay() {
        sucNote.shouldBe(Condition.visible, Duration.ofSeconds(60));
    }

    public void unSuccessfulWay() {
        errNote.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void cardNumberError(String errorText) {
        cardNumberErrorText.shouldHave(Condition.text(errorText)).shouldBe(Condition.visible);
    }

    public void monthError(String errorText) {
        monthErrorText.shouldHave(Condition.text(errorText)).shouldBe(Condition.visible);
    }

    public void yearError(String errorText) {
        yearErrorText.shouldHave(Condition.text(errorText)).shouldBe(Condition.visible);
    }

    public void ownerError(String errorText) {
        ownerErrorText.shouldHave(Condition.text(errorText)).shouldBe(Condition.visible);
    }

    public void cvcError(String errorText) {
        cvvErrorText.shouldHave(Condition.text(errorText)).shouldBe(Condition.visible);
    }

}