package tests.home;

import com.gucci.entities.User;
import com.gucci.entities.UserCreation;
import com.gucci.layers.web.page.home.HomePage;
import com.gucci.utils.WaitManager;
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
public class HomePageTest extends BaseWebTest {
    User user1 = UserCreation.createUser();

    @Test
    public void verifySubscriptionHomePage(){
      var page = open("", HomePage.class).subscribe(user1);
      step(" Verify success message 'You have been successfully subscribed!' is visible",()->{
          page.successSubscribe.shouldBe(visible, Duration.ofSeconds(20));
      });
        WaitManager.pauseInSeconds(10);
    }

}
