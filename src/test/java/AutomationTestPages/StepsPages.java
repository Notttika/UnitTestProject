package AutomationTestPages;

import io.qameta.allure.Step;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StepsPages {

    private WebDriver driver;

    public StepsPages(WebDriver driver) {//создаем конструктор, чтобы инициализироать страницу, который принимает в параметр отконфиг. драйвер
        this.driver = driver;
    }

     @Step("User login for open products")
    public  void UserLogin(){
        driver.get("http://online-sh.herokuapp.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exampleInputEmail1"))).sendKeys("test@test.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exampleInputPassword1"))).sendKeys("test");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-primary')]"))).click();

    }
    @Step("User login for open Registration page")
    public  void UserLoginRandom(){
        driver.get("http://online-sh.herokuapp.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        String uniqueEmailGenerated = RandomString.make(5) + "@test.com";
        String uniquePasswordGenerated = RandomString.make(5) + "test";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exampleInputEmail1"))).sendKeys(uniqueEmailGenerated);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exampleInputPassword1"))).sendKeys(uniquePasswordGenerated);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-primary')]"))).click();

    }

    @Step("Check user is redirected to /products")
       public void  checkUserIsRedirectedToProducts() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/products", currentUrl);
    }
    @Step("Check user is redirected to /login")
    public void checkUserIsRedirectToLogin(){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/login", currentUrl);
    }
}


