package tests.products;

import com.gucci.layers.web.page.product.ProductsPage;
import com.gucci.layers.web.page.home.HomePage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseWebTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static tests.Tags.SMOKE;
import static tests.Tags.WEB;

@Tag(WEB)
@Tag(SMOKE)
public class ProductsPageTest extends BaseWebTest {
    @Test
    @DisplayName("Register new user")
    @Owner("Qairat")
    @Tag("test9")
    public void verifyAllProductsAndProductDetailPage() {
      open("", HomePage.class).waitForPageLoaded();
        var page =  switchSection("Products", ProductsPage.class).
                viewProduct().waitForPageLoaded();
        step("Verify that detail detail is visible: product name, category, price, availability, condition, brand",()->{
            page.productName.shouldBe(visible, Duration.ofSeconds(10));
            page.category.shouldBe(visible, Duration.ofSeconds(10));
            page.price.shouldBe(visible, Duration.ofSeconds(10));
            page.availability.shouldBe(visible, Duration.ofSeconds(10));
            page.condition.shouldBe(visible, Duration.ofSeconds(10));
            page.brand.shouldBe(visible, Duration.ofSeconds(10));

        });
    }

    @Test
    @DisplayName("Register new user")
    @Owner("Qairat")
    @Tag("test9")
    public void searchProduct() {
      open("", HomePage.class).waitForPageLoaded();
        var page =  switchSection("Products", ProductsPage.class)
                .searchProduct();
        step("Verify 'SEARCHED PRODUCTS' is visible",()->{
            page.headingSearchedProducts.shouldBe(visible,Duration.ofSeconds(10));
        });





    }

}
