package com.gucci.layers.web.page;

import com.codeborne.selenide.SelenideElement;
import com.sun.jna.platform.unix.X11;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TestCasesPage extends BasePage<TestCasesPage>{
    SelenideElement testCases = $x("//h2/b[contains(text(),'Test Cases')]");

    @Override
    public TestCasesPage waitForPageLoaded() {
        testCases.shouldBe(visible, Duration.ofSeconds(10));
        return null;
    }
}
