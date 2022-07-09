package AutomationTests;

import AutomationTestPages.ProductsPage;
import AutomationTestPages.StepsPages;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.PageFactory;
import static AutomationTests.BaseSetup.driver;

@Feature("Products functionality")
@ExtendWith(ScreenTestWatcher.class)
public class ProductsTest {
    private static ProductsPage productsPage;
    private static StepsPages stepsPages;

    @BeforeAll
    @Step("Set up driver before tests")
    static void init() {
        BaseSetup baseSetUp = new BaseSetup();
        productsPage = PageFactory.initElements(driver, ProductsPage.class);
        stepsPages = PageFactory.initElements(driver, StepsPages.class);
     }
    @Test
    @Story("Сheck exists elements Products Page")
    public void testCheckElementsProductsPage(){
        //GIVEN
        stepsPages.UserLogin();
        //WHEN
        //THEN
        productsPage.checkLabelAllProducts();
    }
    @Test
    @Story("Сheck exists elements Add Product Page")
    public void testCheckElementsAddProductPage()  {
        //GIVEN
        stepsPages.UserLogin();
        productsPage.clickButtonAddNewProduct();
        //WHEN
        //THEN
        productsPage.checkLabelAddProduct();
        productsPage.checkLabelProductName();
        productsPage.checkLabelProductPrice();
        productsPage.checkLabelEnterProductName();
        productsPage.checkLabelEnterProductPrice();
    }
    @Test
    @Story("Сheck exists  elements Update Product Page")
    public void testCheckElementsUpdateProductPage()  {
        //GIVEN
        stepsPages.UserLogin();
        String existingProductName = "ProductTest111";
        String existingProductPrice = "111";

        //WHEN
        productsPage.clickButtonAddNewProduct();
        productsPage.inputProductName(existingProductName);
        productsPage.inputProductPrice(existingProductPrice);
        productsPage.clickSubmitAddProduct();
        productsPage.clickButtonUpdate();

        //THEN
        productsPage.checkLabelUpdateProduct();
        productsPage.checkLabelProductName();
        productsPage.checkLabelProductPrice();
        productsPage.checkLabelEnterProductName();
        productsPage.checkLabelEnterProductPriceUpdate();
        productsPage.clickSubmitUpdate();


        //THEN
        productsPage.clickButtonDelete();

        //THEN
        productsPage.checkProductDeleted();

    }
    @Test
    @Story("Add a product to the product list and then removing it")
    public void testCheckAddProducts()  {
        //GIVEN
        stepsPages.UserLogin();
        String existingProductName = "ProductTest111";
        String existingProductPrice = "111";

        //WHEN
        productsPage.checkButtonAddNewProductIsEnabled();
        productsPage.checkButtonAddNewProductIsDisplayed();
        productsPage.clickButtonAddNewProduct();
        productsPage.inputProductName(existingProductName);
        productsPage.inputProductPrice(existingProductPrice);
        productsPage.checkSubmitAddProductIsEnabled();
        productsPage.checkSubmitAddProductIsDisplayed();
        productsPage.clickSubmitAddProduct();

        //THEN
        stepsPages.checkUserIsRedirectedToProducts();
        productsPage.checkAddedProduct();

        //WHEN
        productsPage.checkButtonDeleteIsEnabled();
        productsPage.checkButtonDeleteIsDisplayed();
        productsPage.clickButtonDelete();

        //THEN
        productsPage.checkProductDeleted();
    }
    @Test
    @Story("Update the added product to the product list and then remove it")
    public void testCheckUpdateProducts() {
        //GIVEN
        stepsPages.UserLogin();
        String existingProductName = "ProductTest111";
        String existingProductPrice = "111";
        String existingProductName_New = "ProductTest222";
        String existingProductPrice_New = "222";

        //WHEN
        productsPage.clickButtonAddNewProduct();
        productsPage.inputProductName(existingProductName);
        productsPage.inputProductPrice(existingProductPrice);
        productsPage.clickSubmitAddProduct();
        productsPage.checkButtonUpdateIsEnabled();
        productsPage.checkButtonUpdateIsDisplayed();
        productsPage.clickButtonUpdate();
        productsPage.inputUpdateProductName(existingProductName_New);
        productsPage.inputUpdateProductPrice(existingProductPrice_New);
        productsPage.checkSubmitUpdateIsEnabled();
        productsPage.checkSubmitUpdateIsDisplayed();
        productsPage.clickSubmitUpdate();

        //THEN
        stepsPages.checkUserIsRedirectedToProducts();
        productsPage.checkUpdateProduct();

        //WHEN
        productsPage.clickButtonDeleteAfterUpdate();

        //THEN
        productsPage.checkProductDeletedAfterUpdate();
    }

    @Test
    @Story ("Check the transition to the LoginPage")
    public void testCheckButtonLogOut() {
        //GIVEN
        stepsPages.UserLogin();
        //WHEN
        productsPage.checkButtonLogOutIsEnabled();
        productsPage.checkButtonLogOutIsDisplayed();
        productsPage.clickButtonLogOut();

        //THEN
        stepsPages.checkUserIsRedirectToLogin();
    }
    @Test
    @Story ("Check for the existence of the 'Table' element")
    public void testCheckElementTable() {
        //GIVEN
        stepsPages.UserLogin();
        //WHEN
        //THEN
        productsPage.checkAllProductsViewIsPresent();
    }


    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        driver.quit();
    }

}