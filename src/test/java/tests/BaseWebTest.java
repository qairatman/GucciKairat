package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.gucci.data.FakeData;
import com.gucci.entities.User;
import com.gucci.entities.UserCreation;
import com.gucci.layers.web.manager.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.gucci.config.ConfigurationManager.getAppConfig;

public class BaseWebTest {

    User user1 = UserCreation.createUser();

    private final String BASE_URL = getAppConfig().baseURL();

    public static FakeData fakeData;
    public static SoftAssertions softAssertions;

    public <T> T open(String endPoint, Class<T> clazz) {
        return Selenide.open(String.format("%s/%s", BASE_URL,endPoint),clazz);
    }

    public <T> T switchSection(String section, Class<T> clazz) {
        SelenideElement header = $(By.id("header"));
        SelenideElement sectionBtn = header.$x(".//a[normalize-space(text())='"+section+"']");
        sectionBtn.click();
        return Selenide.page(clazz);
    }

    @BeforeAll
    public static void setUp() {
       softAssertions = new SoftAssertions();
        fakeData = new FakeData();
        WebDriverManager.configureBasicWebDriver();

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));

    }

    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }

}