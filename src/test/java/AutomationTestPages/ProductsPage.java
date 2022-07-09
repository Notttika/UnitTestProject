package AutomationTestPages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    By buttonAddNewProduct = By.xpath("//a[contains(.,'Add new product')]");
    By buttonLogOut = By.xpath("//a[@href ='/logout']");
    By labelAllProducts = By.xpath("//h1[contains(.,'All products')]");
    By labelUpdateProduct = By.xpath("//h1[contains(.,'Update product')]");
    By labelProductName = By.xpath("//label[contains(.,'Product name')]");
    By labelProductPrice = By.xpath("//label[contains(.,'Product price')]");
    By labelEnterProductName = By.xpath("//div[@id=\"productHelp\"]");
    By labelEnterProductPrice = By.id("priceHelp");
    By labelEnterProductPriceUpdate = By.xpath("//div[text()='Enter product price']");
    By labelAddProduct = By.xpath("//h1[contains(.,'Add product')]");
    By productName = By.id("exampleInputProduct1");
    By productPrice = By.id("exampleInputPrice1");
    By submitAddProduct = By.xpath("//button[contains(.,'Submit')]");
    By updateProductName = By.id("exampleInputProduct1");
    By updateProductPrice = By.id("exampleInputPrice1");
    By submitUpdate = By.xpath("//button[contains(.,'Submit')]");
    By addedProduct = By.xpath("//td[text()='ProductTest111']");
    By updateProduct = By.xpath("//td[text()='ProductTest222']");
    By buttonDelete = RelativeLocator.with(By.xpath("//button[contains(.,'Delete')]")).toRightOf(addedProduct);
    By buttonDeleteAfterUpdate = RelativeLocator.with(By.xpath("//button[contains(.,'Delete')]")).toRightOf(updateProduct);
    By buttonUpdate = RelativeLocator.with(By.xpath("//button[contains(.,'Update')]")).toRightOf(addedProduct);
    @FindBy(tagName = "table")
    private List<WebElement> allProductsView;

    public ProductsPage(WebDriver driver) {//создаем конструктор, чтобы инициализироать страницу, который принимает в параметр отконфиг. драйвер
        this.driver = driver;
    }

    @Step ("Check for the existence label 'All products'")
    public ProductsPage checkLabelAllProducts() {
        WebElement elementLabel = driver.findElement(labelAllProducts);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Update product'")
    public ProductsPage checkLabelUpdateProduct() {
        WebElement elementLabel = driver.findElement(labelUpdateProduct);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Product name'")
    public ProductsPage checkLabelProductName() {
        WebElement elementLabel = driver.findElement(labelProductName);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Product price'")
    public ProductsPage checkLabelProductPrice() {
        WebElement elementLabel = driver.findElement(labelProductPrice);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Enter a product name'")
    public ProductsPage checkLabelEnterProductName() {
        WebElement elementLabel = driver.findElement(labelEnterProductName);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Enter a product price'")
    public ProductsPage checkLabelEnterProductPrice()  {
        WebElement elementLabel = driver.findElement(labelEnterProductPrice);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Enter a product price'")
    public ProductsPage checkLabelEnterProductPriceUpdate()  {
        WebElement elementLabel = driver.findElement(labelEnterProductPriceUpdate);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Check for the existence label 'Add product'")
    public ProductsPage checkLabelAddProduct() {
        WebElement elementLabel = driver.findElement(labelAddProduct);
        org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        return this;
    }
    @Step ("Click button 'Add new product' to check the transition to the page Add product")
    public ProductsPage clickButtonAddNewProduct() {
        driver.findElement(buttonAddNewProduct).click();
        return this;
    }
    @Step ("Click button 'Update' to check the transition to the page Update product")
    public ProductsPage clickButtonUpdate() {
        driver.findElement(buttonUpdate).click();
        return this;
    }
    @Step ("Click button 'Submit' to check product update in product list")
    public ProductsPage clickSubmitUpdate() {
        driver.findElement(submitUpdate).click();
        return this;
    }
    @Step ("Click button 'Delete' to check product removal in product list")
    public ProductsPage clickButtonDelete() {
        driver.findElement(buttonDelete).click();
        return this;
    }
    @Step ("Click button 'Submit' to check if a product has been added to the product list")
    public ProductsPage clickSubmitAddProduct() {
        driver.findElement(submitAddProduct).click();
        return this;
    }
    @Step ("Click button 'Delete' to check product removal after update in product list")
    public ProductsPage clickButtonDeleteAfterUpdate() {
        driver.findElement(buttonDeleteAfterUpdate).click();
        return this;
    }
    @Step ("Check if the added product is removed from the product list")
   public ProductsPage checkProductDeleted() {
        List<WebElement> elements = driver.findElements(addedProduct);
        Assertions.assertTrue(elements.isEmpty());
        return this;
    }
    @Step ("Check that the updated product has been removed from the product list")
    public ProductsPage checkProductDeletedAfterUpdate() {
        List<WebElement> elements = driver.findElements(updateProduct);
        Assertions.assertTrue(elements.isEmpty());
        return this;
    }

    @Step ("Click button 'LogOut' to check the transition to the LoginPage")
    public ProductsPage clickButtonLogOut() {
        WebElement buttonElement = driver.findElement(buttonLogOut);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", buttonElement);
        return this;
    }

    @Step ("Set product name as '{productNameText}'")
    public ProductsPage inputProductName(String productNameText) {
        driver.findElement(productName).sendKeys(productNameText);
        return this;
    }
    @Step ("Set product price as '{productPriceText}'")
    public ProductsPage inputProductPrice(String productPriceText) {
        driver.findElement(productPrice).sendKeys(productPriceText);
        return this;
    }
    @Step ("Check that the added product has been added to the list of products")
    public ProductsPage checkAddedProduct() {
        WebElement elementProduct = driver.findElement(addedProduct);
        org.assertj.core.api.Assertions.assertThat(elementProduct).isNotNull();
        return this;
    }
    @Step ("Check that the added product is update to the list of products")
    public ProductsPage checkUpdateProduct() {
        WebElement elementProduct = driver.findElement(updateProduct);
        org.assertj.core.api.Assertions.assertThat(elementProduct).isNotNull();
        return this;
    }

    @Step ("Set new product name as '{updateProductText}'")
    public ProductsPage inputUpdateProductName(String updateProductText) {
        driver.findElement(updateProductName).clear();
        driver.findElement(updateProductName).sendKeys(updateProductText);
        return this;
    }
    @Step ("Set new product price as '{updatePriceText}'")
    public ProductsPage inputUpdateProductPrice(String updatePriceText) {
        driver.findElement(updateProductPrice).clear();
        driver.findElement(updateProductPrice).sendKeys(updatePriceText);
        return this;
    }
    @Step ("check button 'Add new product' for visibility")
    public ProductsPage checkButtonAddNewProductIsDisplayed(){
        boolean displayed = driver.findElement(buttonAddNewProduct).isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }
    @Step ("check button 'Add new product' for activity")
    public ProductsPage checkButtonAddNewProductIsEnabled(){
        boolean enabled = driver.findElement(buttonAddNewProduct).isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("check button 'Log out' for visibility")
    public ProductsPage checkButtonLogOutIsDisplayed(){
        boolean displayed = driver.findElement(buttonLogOut).isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }
    @Step ("check button 'Log out' for activity")
    public ProductsPage checkButtonLogOutIsEnabled(){
        boolean enabled = driver.findElement(buttonLogOut).isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("check button 'Submit' for visibility")
    public ProductsPage checkSubmitAddProductIsDisplayed(){
        boolean displayed = driver.findElement(submitAddProduct).isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }
    @Step ("check button 'Submit' for activity")
    public ProductsPage checkSubmitAddProductIsEnabled(){
        boolean enabled = driver.findElement(submitAddProduct).isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("check button 'Submit' for visibility")
    public ProductsPage checkSubmitUpdateIsDisplayed(){
        boolean displayed = driver.findElement(submitUpdate).isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }
    @Step ("check button 'Submit' for activity")
    public ProductsPage checkSubmitUpdateIsEnabled(){
        boolean enabled = driver.findElement(submitUpdate).isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("check button 'Update' for visibility")
    public ProductsPage checkButtonUpdateIsDisplayed(){
        boolean displayed = driver.findElement(buttonUpdate).isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }
    @Step ("check button 'Update' for activity")
    public ProductsPage checkButtonUpdateIsEnabled(){
        boolean enabled = driver.findElement(buttonUpdate).isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("check button 'Delete' for visibility")
    public ProductsPage checkButtonDeleteIsDisplayed(){
        boolean displayed = driver.findElement(buttonDelete).isDisplayed();
        Assertions.assertTrue(displayed);
        return this;
    }
    @Step ("check button 'Delete' for activity")
    public ProductsPage checkButtonDeleteIsEnabled(){
        boolean enabled = driver.findElement(buttonDelete).isEnabled();
        Assertions.assertTrue(enabled);
        return this;
    }
    @Step ("Check element  table exists")
    public ProductsPage checkAllProductsViewIsPresent(){
        org.assertj.core.api.Assertions.assertThat(allProductsView.size()).isEqualTo(1);
        return this;
    }
}
