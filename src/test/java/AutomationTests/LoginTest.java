package AutomationTests;

import AutomationTestPages.LoginPage;
import AutomationTestPages.StepsPages;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import static AutomationTests.BaseSetup.driver;

@Feature("Login functionality")
@ExtendWith(ScreenTestWatcher.class)
public class LoginTest {

    private static LoginPage loginPage;
    private static StepsPages stepsPages;


    @BeforeAll
    @Step("Set up driver before tests")
    static void init() {
        BaseSetup baseSetUp = new BaseSetup();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        stepsPages = PageFactory.initElements(driver, StepsPages.class);
    }
    @Test
    @Story("Login successful")
    @Description("Check login is successful after entering valid credentials")
    public void testClick() throws MalformedURLException {
        //GIVEN
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "test";

        //WHEN
        loginPage.openLoginPage();
        loginPage.shouldLinkOnlineShop();
        loginPage.shouldNavigateOnlineShop();

        loginPage.checkEmailInputIsEnabled();
        loginPage.setEmail(existingUserEmail);

        loginPage.checkPasswordInputIsEnabled();
        loginPage.setPassword(existingUserPassword);

        loginPage.checkButtonLoginIsDisplayed();
        loginPage.submit();

        //THEN
        stepsPages.checkUserIsRedirectedToProducts();
        }
    @Test
    @Story("Check label elements LoginPages")
    public void checkLabelElements() {
        //GIVEN
        //WHEN
        loginPage.openLoginPage();
        //THEN
        loginPage.checkLabelEmail();
        loginPage.checkLabelEmailHelp();
        loginPage.checkLabelPassword();
    }
    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        driver.quit();
    }
}
