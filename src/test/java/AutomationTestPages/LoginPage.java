package AutomationTestPages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id="exampleInputEmail1")
    private WebElement emailInput;
    @FindBy(id="exampleInputPassword1")
    private WebElement passwordInput;
    @FindBy(how = How.XPATH,using = "//button[contains(@class,'btn-primary')]")
    private WebElement submitButton;
    @FindBy(how = How.XPATH,using = "//label[contains(.,'Email address')]")
    private WebElement labelEmailAddress;
    @FindBy(how = How.XPATH,using = "//label[contains(.,'Password')]")
    private WebElement labelPassword;
    @FindBy(id ="emailHelp")
    private List<WebElement> labelEmailHelp;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check 'Email' field attribute exists")
    public LoginPage checkEmailInputIsEnabled(){
        boolean enabled = emailInput.isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("Check 'Password' field attribute exists")
    public LoginPage checkPasswordInputIsEnabled(){
        boolean enabled = passwordInput.isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("Set email as '{emailText}'")
    public LoginPage setEmail(String emailText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(emailText);
        return this;
    }
    @Step ("Set password as '{passwordText}'")
    public LoginPage setPassword(String passwordText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(passwordText);
        return this;
    }
    @Step ("Click submit button to heck login is successful after entering valid credentials")
    public LoginPage submit() {
        submitButton.click();
        return this;
    }
    @Step ("Open login page")
    public LoginPage openLoginPage(){
        driver.get("http://online-sh.herokuapp.com/login");
        return this;
    }
    @Step ("Check header")
    public LoginPage shouldNavigateOnlineShop () throws MalformedURLException {
        String testUrl = "http://online-sh.herokuapp.com/login";
        driver.navigate().to(new URL(testUrl));
        Assertions.assertEquals("Online Shop", driver.getTitle());
        return this;
    }
    @Step ("Check link validation")
    public LoginPage shouldLinkOnlineShop (){
        Assertions.assertEquals("http://online-sh.herokuapp.com/login", driver.getCurrentUrl());
        return this;
    }
    @Step  ("Check for the existence label 'Email'")
    public LoginPage checkLabelEmail() {
       org.assertj.core.api.Assertions.assertThat(labelEmailAddress).isNotNull();
        return this;

    }
    @Step ("Check for the existence label 'Password'")
    public LoginPage checkLabelPassword() {
        org.assertj.core.api.Assertions.assertThat(labelPassword).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Email Help'")
    public LoginPage checkLabelEmailHelp() {
        boolean elementTru = labelEmailHelp.get(0).getText().contains("We'll never");
        Assertions.assertTrue(elementTru);
        return this;
    }
    @Step ("Check visibility of the button element")
    public LoginPage checkButtonLoginIsDisplayed(){
        boolean displayed = passwordInput.isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }

}
