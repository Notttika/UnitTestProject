package AutomationTests;

import AutomationTestPages.RegistrationPage;
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
import static AutomationTests.BaseSetup.driver;

@Feature("Registration functionality")
@ExtendWith(ScreenTestWatcher.class)
public class RegistrationTest {
    private static RegistrationPage registrationPage;
    private static StepsPages stepsPages;

    @BeforeAll
    @Step("Set up driver before tests")
    static void init() {
        BaseSetup baseSetUp = new BaseSetup();
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        stepsPages = PageFactory.initElements(driver, StepsPages.class);
    }
    @Test
    @Story("Registration successful")
    @Description("Check registration is successful after entering valid credentials")
    public void testRegistration()  {
        //Given
        String existingUserName = "Nataliya";
        String existingUserLastName = "Lobodyuk";
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "test";
        //When
        stepsPages.UserLoginRandom();
        registrationPage.shouldLinkRegistrationPage();

        registrationPage.checkNameRegistrationInputIsEnabled();
        registrationPage.setName(existingUserName);

        registrationPage.checkLastNameRegistrationInputIsEnabled();
        registrationPage.setLastName(existingUserLastName);

        registrationPage.checkEmailRegistrationInputIsEnabled();
        registrationPage.setEmailRegistration(existingUserEmail);

        registrationPage.checkPasswordRegistrationInputIsEnabled();
        registrationPage.setPasswordRegistration(existingUserPassword);

        registrationPage.checkButtonRegistrationIsDisplayed();
        registrationPage.submitRegistration();

        //Then
        stepsPages.checkUserIsRedirectToLogin();
    }
    @Test
    @Story("Check label elements RegistrationPage")
    public void checkLabelElements() {
        //GIVEN
        //WHEN
        stepsPages.UserLoginRandom();
        //THEN
        registrationPage.checkLabelName();
        registrationPage.checkLabelLastName();
        registrationPage.checkLabelEmailAddressRegistration();
        registrationPage.checkLabelPasswordRegistration();
        registrationPage.checkLabelEmailHelpRegistration();
    }
    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        driver.quit();
    }
}
