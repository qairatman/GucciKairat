package com.gucci.layers.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.gucci.entities.User;
import com.gucci.layers.web.page.home.HomePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ContactUsFormPage extends BasePage<ContactUsFormPage> {

    public SelenideElement getInTouch = $x("//p[normalize-space()='Your email or password is incorrect!']");
    public SelenideElement inputName = $x("//input[@data-qa='name']");
    public SelenideElement inputEmail = $x("//input[@data-qa='email']");
    public SelenideElement inputSubject = $x("//input[@data-qa='subject']");
    public SelenideElement inputMessage = $x("//textarea[@data-qa='message']");
    public SelenideElement inputUploadFile = $x("//input[@name='upload_file']");
    public SelenideElement btnSubmit = $x("//input[@data-qa='submit-button']");
    public SelenideElement successMessage = $x("//div[@class='status alert alert-success']");
    public SelenideElement goHomeBtn = $x("//span[contains(text(),'Home')]");

    @Override
    public ContactUsFormPage waitForPageLoaded() {
        getInTouch.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }


    @Step("Enter name, email, subject and message")
    public ContactUsFormPage fillFields(User user) {
        elementManager
                .input(inputName, user.getName())
                .input(inputEmail, user.getEmail())
                .input(inputSubject, "Math")
                .input(inputMessage, "Lorem ipsum bitch");
        return this;
    }

    @Step("Enter name, email, subject and message,click ok,verify success,")
    public ContactUsFormPage uploadFile() {

        elementManager.input(inputUploadFile, "/Users/Agema/Desktop/Снимок экрана 2025-07-06 в 22.27.59.png");
        elementManager
                .click(btnSubmit);
        Selenide.switchTo().alert().accept();

        return this;
    }

    @Step("ok,verify success,click Home button")
    public HomePage goHome() {

        elementManager.click(goHomeBtn);
        return page(HomePage.class);
    }
}
