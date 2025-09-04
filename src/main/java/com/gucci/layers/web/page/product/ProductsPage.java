package com.gucci.layers.web.page.product;

import com.codeborne.selenide.SelenideElement;
import com.gucci.layers.web.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ProductsPage extends BasePage<ProductsPage> {
    SelenideElement allProductTextHeading = $x("//h2[contains(text(),'All Products')]");
    SelenideElement allProductList = $x("//h2[contains(text(),'All Products')]/..");
    SelenideElement firstProduct = $x("//a[normalize-space()='View Product']");
    SelenideElement inputSearch = $x("//input[@id='search_product']");
    SelenideElement buttonSearch = $x("//button[@id='submit_search']");
    public SelenideElement headingSearchedProducts = $x("//h2[normalize-space()='Searched Products']");


    @Override
    public ProductsPage waitForPageLoaded() {
        elementManager.isVisible(allProductTextHeading).isVisible(allProductList);
        return this;
    }

    @Step("Click on 'View Product' of first product")
    public ProductDetailsPage viewProduct() {
        elementManager.click(firstProduct);
        return page(ProductDetailsPage.class);
    }

    @Step("Click on 'View Product' of first product")
    public ProductsPage searchProduct() {
        elementManager.input(inputSearch, "jeans")
                .click(buttonSearch);
        return page(ProductsPage.class);
    }


}
