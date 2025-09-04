package com.gucci.layers.web.page.auth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gucci.entities.User;
import com.gucci.layers.web.page.BasePage;
import com.gucci.layers.web.page.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountFieldsPage extends BasePage<CreateAccountFieldsPage> {
    SelenideElement enterAccInfoHeader = $x("//h2[normalize-space()='Enter Account Information']");
    SelenideElement titleM = $x("//div[normalize-space()='Mr.']");
    SelenideElement titleF = $x("//div[normalize-space()='Mrs.']");
    SelenideElement nameInput = $x("//input[@data-qa='name']");
    SelenideElement emailInput = $x("//input[@data-qa='email']");
    SelenideElement passwordPassword = $x("//input[@data-qa='password']");
    SelenideElement selectDay = $(By.id("days"));
    SelenideElement selectMonth = $(By.id("months"));
    SelenideElement selectYear = $(By.id("years"));
    SelenideElement checkBoxNewLetter = $x("//label[normalize-space()='Sign up for our newsletter!']");
    SelenideElement checkBoxSpecialOffers = $x("//label[normalize-space()='Receive special offers from our partners!']");
    SelenideElement fistNameInput = $x("//input[@data-qa='first_name']");
    SelenideElement lastNameInput = $x("//input[@data-qa='last_name']");
    SelenideElement companyInput = $x("//input[@data-qa='company']");
    SelenideElement addressInput = $x("//input[@data-qa='address']");
    SelenideElement address2Input = $x("//input[@data-qa='address2']");
    SelenideElement selectCountry = $x("//select[@data-qa='country']");
    SelenideElement stateInput = $x("//input[@data-qa='state']");
    SelenideElement cityInput = $x("//input[@data-qa='city']");
    SelenideElement zipcodeInput = $x("//input[@data-qa='zipcode']");
    SelenideElement mobileNumberInput = $x("//input[@data-qa='mobile_number']");
    SelenideElement createAccBtn = $x("//button[@data-qa='create-account']");
    SelenideElement createdH2 = $x("//h2[normalize-space()='Account Created!']");
    SelenideElement continueBtn = $x("//a[normalize-space()='Continue']");


    public static String splitDate(User user, int dmy) {
        String[] parts = user.getDataOfBirth().split("-");
        return parts[dmy - 1];
    }

    @Override
    public CreateAccountFieldsPage waitForPageLoaded() {
        enterAccInfoHeader.shouldHave(Condition.exactText("Enter Account Information"));
        return null;
    }


    @Step("Fill details: Title, Name, Email, Password, Date of birth {0}")
    public CreateAccountFieldsPage fillDetailsTitleNameEmailPassWordDoB(User user) {
        switch (user.getTitle()) {
            case "1":
                elementManager.click(titleM);
                break;
            case "2":
                elementManager.click(titleF);
        }
        elementManager
                .input(passwordPassword, user.getPassword());
            selectDay.selectOptionByValue(splitDate(user,1));
            selectMonth.selectOptionByValue(splitDate(user,2));
            selectYear.selectOptionByValue(splitDate(user,3));
        return this;
    }

    @Step("Select checkbox 'Sign up for our newsletter!'")
    public CreateAccountFieldsPage clickCheckBox1() {
        elementManager.click(checkBoxNewLetter);
        return this;
    }

    @Step("Select checkbox 'Receive special offers from our partners!'")
    public CreateAccountFieldsPage clickCheckBox2() {
        elementManager.click(checkBoxSpecialOffers);
        return this;
    }

    @Step("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public CreateAccountFieldsPage FillRestOfFields(User user){
        elementManager.input(fistNameInput,user.getFirstName())
                .input(lastNameInput,user.getLastName())
                .input(companyInput,user.getCompany())
                .input(addressInput,user.getAddress())
                .input(address2Input,user.getAddress2());
        selectCountry.selectOptionContainingText(user.getCountries().getCountry());
        elementManager.input(stateInput,user.getState())
                .input(cityInput,user.getCity())
                .input(zipcodeInput,user.getZipcode())
                .input(mobileNumberInput,user.getMobileNumber())
                .click(createAccBtn.scrollTo());
        return this;
    }

    @Step("Verify that 'ACCOUNT CREATED!' is visible,Click Continue")
    public HomePage verifyThatAccountCreated(){
        elementManager.isVisible(createdH2);
        elementManager.click(continueBtn);
        return page(HomePage.class);
    }

}
