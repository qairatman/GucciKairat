package tests.testCases;

import com.gucci.layers.web.page.TestCasesPage;
import com.gucci.layers.web.page.home.HomePage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseWebTest;

import static com.codeborne.selenide.Selenide.open;
import static tests.Tags.SMOKE;
import static tests.Tags.WEB;


@Tag(WEB)
@Tag(SMOKE)
public class TestCasesTest extends BaseWebTest {

    @Test
    @DisplayName("TestCases test")
    @Owner("Qairat")
    @Tag("test7")
    public void testCasesTest(){
        open("", HomePage.class);
        switchSection("Test Cases", TestCasesPage.class).waitForPageLoaded();

    }
}
