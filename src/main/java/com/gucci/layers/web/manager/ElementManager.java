package com.gucci.layers.web.manager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class ElementManager {

    public final int DELAY = 10;

    public ElementManager click(SelenideElement element) {
        element
                .shouldBe(visible, Duration.ofSeconds(DELAY))
                .shouldBe(enabled, Duration.ofSeconds(DELAY))
                .shouldNotBe(attribute("disabled"), Duration.ofSeconds(DELAY))
                .shouldBe(clickable, Duration.ofSeconds(DELAY))
                .click();
        return this;
    }

    public ElementManager input(SelenideElement element, String text) {
        element
                .shouldBe(visible, Duration.ofSeconds(DELAY))
                .shouldBe(enabled, Duration.ofSeconds(DELAY))
                .scrollTo()
                .sendKeys(text);
        return this;
    }

    public String getText(SelenideElement element) {
        element
                .shouldBe(visible, Duration.ofSeconds(DELAY))
                .shouldBe(enabled, Duration.ofSeconds(DELAY));
        return element.getText();
    }
    public ElementManager isVisible(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(DELAY));
return this;
    }

}
