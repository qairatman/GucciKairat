package tests.register;

import com.gucci.entities.User;
import com.gucci.entities.UserCreation;
import com.gucci.layers.web.page.home.HomePage;
import com.gucci.utils.WaitManager;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseWebTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static tests.Tags.SMOKE;
import static tests.Tags.WEB;

@Tag(SMOKE)
@Tag(WEB)
public class RegistrationTest extends BaseWebTest {
    User user1 = UserCreation.createUser();

    @DisplayName("Registration method for DRY")
    @Owner("Qairat")
    public HomePage register() {
        var page = open("", HomePage.class);
        getWebDriver().manage().window().maximize();
        page.clickSingUpLoginBtn()
                .fillSingUpInputs(user1)
                .fillDetailsTitleNameEmailPassWordDoB(user1)
                .clickCheckBox1()
                .clickCheckBox2()
                .FillRestOfFields(user1)
                .verifyThatAccountCreated().
                verifyThatLoggedInBy();

        return page(HomePage.class);


    }

    @Test
    @DisplayName("Register new user")
    @Owner("Qairat")
    @Tag("test1")
    public void registerNewUserTest() {
        register()
                .deleteAccount();

    }

    @Test
    @DisplayName("Login with correct Credentials")
    @Owner("Qairat")
    @Tag("test2")
    public void correctCredentialsLogin() {
        register().logout()
                .fillLoginInput(user1)
                .deleteAccount();
        WaitManager.pauseInSeconds(10);


    }

    @Test
    @DisplayName("Login with incorrect Credentials")
    @Owner("Qairat")
    @Tag("test3")
    public void wrongCredentialsLoginTest() {
        register().logout()
                .fillIncorrectLoginInputs(user1)
                .verifyIncorrectPasswordOrEmailErr();
        WaitManager.pauseInSeconds(10);

    }

    @Test
    @DisplayName("test logout btn after authorization")
    @Owner("Qairat")
    @Tag("test4")
    public void logoutTest() {
        var a = register().logout();
        step("Verify That navigated to Login page", () -> {
            BaseWebTest.softAssertions.assertThat(a.loginHeader.shouldBe(visible, Duration.ofSeconds(10)));
        });
        BaseWebTest.softAssertions.assertAll();

    }

    @Test
    @DisplayName("Sign up with existing account credentials")
    @Owner("Qairat")
    @Tag("test5")
    public void signUpWithExistingCredentials() {
        var a = register().logout().fillWithExistingCredSingUpInputs(user1);
        step("Verify error 'Email Address already exist!' is visible", () -> {
            BaseWebTest.softAssertions.assertThat(a.alreadyExistErr.shouldBe(visible, Duration.ofSeconds(10)));
        });
        BaseWebTest.softAssertions.assertAll();


    }




}
