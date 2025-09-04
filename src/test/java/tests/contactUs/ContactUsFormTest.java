package tests.contactUs;

import com.gucci.entities.User;
import com.gucci.entities.UserCreation;
import com.gucci.layers.web.page.home.HomePage;
import com.gucci.utils.WaitManager;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseWebTest;
import tests.Tags;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

@Tag(Tags.WEB)
@Tag(Tags.SMOKE)
public class ContactUsFormTest extends BaseWebTest {

    User user1 = UserCreation.createUser();

    @Test
    @DisplayName("test logout btn after authorization")
    @Owner("Qairat")
    @Tag("test6")
    public void contactUsSectionTest() {
        var page = open("", HomePage.class);
        getWebDriver().manage().window().maximize();
        var page2 = page.clickContactusBtn()
                .fillFields(user1)
                .uploadFile();
        step(("Verify success message 'Success! Your details have been submitted successfully.' is visible"), () -> {

            page2.successMessage.scrollTo().
                    shouldBe(visible, Duration.ofSeconds(10));
        });
        page2.goHome()
                .waitForPageLoaded();
        WaitManager.pauseInSeconds(10);

    }
}
