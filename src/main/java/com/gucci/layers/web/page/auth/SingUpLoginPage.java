package com.gucci.layers.web.page.auth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.gucci.entities.User;
import com.gucci.layers.web.page.BasePage;
import com.gucci.layers.web.page.home.HomePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;


public class SingUpLoginPage extends BasePage<SingUpLoginPage> {

    public SelenideElement loginHeader = $x("//h2[normalize-space()='Login to your account']");
    public SelenideElement inputLogin = $x("//input[@data-qa='login-email']");
    public SelenideElement inputPassword = $x("//input[@data-qa='login-password']");
    public SelenideElement loginBtn = $x("//button[@data-qa='login-button']");
    public SelenideElement signUpHeader = $x("//h2[normalize-space()='New User Signup!']");
    public SelenideElement inputSingUpName = $x("//input[@data-qa='signup-name']");
    public SelenideElement inputSingUpEmail = $x("//input[@data-qa='signup-email']");
    public SelenideElement singUpBtn = $x("//button[@data-qa='signup-button']");
    public SelenideElement errorThatIncorrectCred = $x("//p[normalize-space()='Your email or password is incorrect!']");
    public SelenideElement alreadyExistErr = $x(" //p[contains(text(),'Email Address already exist!')]");

    @Override
    public SingUpLoginPage waitForPageLoaded() {
        loginHeader.shouldHave(Condition.exactText("Login to your account"));
        return this;
    }
    @Step("Fill Sing up inputs")
    public CreateAccountFieldsPage fillSingUpInputs (User user) {
     elementManager.input(inputSingUpName,user.getName())
             .input(inputSingUpEmail,user.getEmail())
             .click(singUpBtn);
        return Selenide.page(CreateAccountFieldsPage.class);
    }
    @Step("Fill Sing up inputs")
    public SingUpLoginPage fillWithExistingCredSingUpInputs (User user) {
        elementManager.input(inputSingUpName,user.getName())
                .input(inputSingUpEmail,user.getEmail())
                .click(singUpBtn);
        return Selenide.page(SingUpLoginPage.class);
    }


    public HomePage fillLoginInput(User user){
        elementManager.isVisible(loginHeader)
                .input(inputLogin,user.getEmail())
                .input(inputPassword,user.getPassword())
                .click(loginBtn);
        return page(HomePage.class);
    }

    public SingUpLoginPage fillIncorrectLoginInputs(User user){
        elementManager.isVisible(loginHeader)
                .input(inputLogin,user.getEmail()+2)
                .input(inputPassword,user.getPassword()+1)
                .click(loginBtn);
        return page(SingUpLoginPage.class);
    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    public SingUpLoginPage verifyIncorrectPasswordOrEmailErr(){
        elementManager.isVisible(errorThatIncorrectCred);
        return page(SingUpLoginPage.class);
    }




}


