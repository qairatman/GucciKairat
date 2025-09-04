package com.gucci.layers.web.page.home;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gucci.entities.User;
import com.gucci.layers.web.page.BasePage;
import com.gucci.layers.web.page.ContactUsFormPage;
import com.gucci.layers.web.page.auth.SingUpLoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.security.Key;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePage<HomePage> {
    SelenideElement homeBtn = $x("//a[@href='/' and contains(text(),'Home')]");
    SelenideElement singUpLoginBtn = $x("//a[normalize-space()='Signup / Login']");
    SelenideElement contactUsBtn = $x("//a[normalize-space()='Contact us']");
    SelenideElement LoggedAsInfo = $x("//a[contains(text(),'Logged in as')]");
    SelenideElement deleteBtn = $x("//a[normalize-space()='Delete Account']");
    SelenideElement deletedH2 = $x("//h2[normalize-space()='Account Deleted!']");
    SelenideElement logoutBtn = $x("//a[contains(text(),'Logout')]");
    SelenideElement continueBtn = $x("//a[normalize-space()='Continue']");
    SelenideElement subscribeInput = $x("//input[@id='susbscribe_email']");
    public SelenideElement successSubscribe = $x("//div[@id='success-subscribe']");


    @Override
    public HomePage waitForPageLoaded() {
        homeBtn.shouldHave(Condition.attribute("style", "color: orange;"));
        return this;
    }


    @Step("Click sing up/login button")
    public SingUpLoginPage clickSingUpLoginBtn() {
        elementManager.click(singUpLoginBtn);
        return new SingUpLoginPage();
    }

    @Step("Click  Contact us button")
    public ContactUsFormPage clickContactusBtn() {
        elementManager.click(contactUsBtn);
        return page(ContactUsFormPage.class);
    }

    @Step("Verify that 'Logged in as username' is visible")
    public HomePage verifyThatLoggedInBy() {
        elementManager.isVisible(LoggedAsInfo);
        return this;
    }

    @Step("Delete Account")
    public HomePage deleteAccount() {
        elementManager.click(deleteBtn)
                .isVisible(deletedH2)
                .click(continueBtn);
        return this;
    }

    @Step("logout ")
    public SingUpLoginPage logout() {
        elementManager
                .click(logoutBtn);

        return page(SingUpLoginPage.class);
    }

    @Step("Subs ")
    public HomePage subscribe(User user) {
        elementManager.input(subscribeInput, user.getEmail());
        subscribeInput.sendKeys(Keys.ENTER);

        return this;
    }

}
