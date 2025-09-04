package com.gucci.layers.web.page.product;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.gucci.layers.web.page.BasePage;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Selenide.$x;

public class ProductDetailsPage extends BasePage<ProductDetailsPage> {
    public SelenideElement productName = $x("//div[@class='product-information']//h2");
    public SelenideElement category = $x("//div[@class='product-information']//p[contains(text(),'Category:')]");
    public SelenideElement price = $x("//span[contains(text(),'Rs.')]");
    public SelenideElement availability = $x("//b[contains(text(),'Availability:')]");
    public SelenideElement condition = $x("//b[contains(text(),'Condition:')]");
    public SelenideElement brand = $x("//b[contains(text(),'Brand:')]");

    @Override
    public ProductDetailsPage waitForPageLoaded() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(WebDriverRunner.url()).isEqualTo("https://automationexercise.com/product_details/1");
       return this;
    }
}
