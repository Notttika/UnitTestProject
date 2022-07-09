package AutomationTestPages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(name = "name")
    private WebElement nameRegistrationInput;
    @FindBy(name = "last_Name")
    private WebElement lastNameRegistrationInput;
    @FindBy(id = "exampleInputEmail1")
    private WebElement emailRegistrationInput;
    @FindBy(id = "exampleInputPassword1")
    private WebElement passwordRegistrationInput;
    @FindBy(tagName = "button")
    private WebElement submitButtonRegistration;
    @FindBy(xpath = "//label[text()='Name']")
    private WebElement labelName;
    @FindBy(xpath = "//label[text()='Last Name']")
    private WebElement labelLastName;
    @FindBy(xpath = "//label[text()='Email address']")
    private WebElement labelEmailAddressRegistration;
    @FindBy(xpath = "//label[text()='Password']")
    private WebElement labelPasswordRegistration;
    @FindBy(id = "emailHelp")
    private WebElement labelEmailHelpRegistration;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Set name as '{nameText}'")
    public RegistrationPage setName(String nameText) {
        nameRegistrationInput.sendKeys(nameText);
        return this;
    }

    @Step("Set last name as '{lastNameText}'")
    public RegistrationPage setLastName(String lastNameText) {
        lastNameRegistrationInput.sendKeys(lastNameText);
        return this;
    }

    @Step ("Set email as '{emailText}'")
    public RegistrationPage setEmailRegistration(String emailText) {
        emailRegistrationInput.sendKeys(emailText);
        return this;
    }

    @Step ("Set password as '{passwordText}'")
    public RegistrationPage setPasswordRegistration(String passwordText) {
        passwordRegistrationInput.sendKeys(passwordText);
        return this;
    }

    @Step ("Click submit button to check successful user registration")
    public RegistrationPage submitRegistration() {
        submitButtonRegistration.click();
        return this;
    }

    @Step  ("Check for the existence label 'Name'")
    public RegistrationPage checkLabelName(){
        org.assertj.core.api.Assertions.assertThat(labelName).isNotNull();
        return this;
    }

    @Step  ("Check for the existence label 'Last name'")
    public RegistrationPage checkLabelLastName(){
        org.assertj.core.api.Assertions.assertThat(labelLastName).isNotNull();
        return this;
    }

    @Step  ("Check for the existence label 'Email address'")
    public RegistrationPage checkLabelEmailAddressRegistration(){
        org.assertj.core.api.Assertions.assertThat(labelEmailAddressRegistration).isNotNull();
        return this;
    }

    @Step  ("Check for the existence label 'Email password'")
    public RegistrationPage checkLabelPasswordRegistration(){
        org.assertj.core.api.Assertions.assertThat(labelPasswordRegistration).isNotNull();
        return this;
    }

    @Step ("Check for the existence label 'Email Help'")
    public RegistrationPage checkLabelEmailHelpRegistration(){
        org.assertj.core.api.Assertions.assertThat(labelEmailHelpRegistration).isNotNull();
        return this;
    }

    @Step("Check 'Name' field attribute exists")
    public RegistrationPage checkNameRegistrationInputIsEnabled(){
        boolean enabled = nameRegistrationInput.isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }

    @Step("Check 'Last name' field attribute exists")
    public RegistrationPage checkLastNameRegistrationInputIsEnabled(){
        boolean enabled = lastNameRegistrationInput.isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }

    @Step("Check 'Email' field attribute exists")
    public RegistrationPage checkEmailRegistrationInputIsEnabled(){
        boolean enabled = emailRegistrationInput.isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }

    @Step("Check 'Password' field attribute exists")
    public RegistrationPage checkPasswordRegistrationInputIsEnabled(){
        boolean enabled = passwordRegistrationInput.isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }

    @Step ("Check visibility of the button element")
    public RegistrationPage checkButtonRegistrationIsDisplayed(){
        boolean displayed = passwordRegistrationInput.isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }

    @Step ("Check link validation")
    public RegistrationPage shouldLinkRegistrationPage(){
        Assertions.assertEquals("http://online-sh.herokuapp.com/registration", driver.getCurrentUrl());
        return this;
    }
}
