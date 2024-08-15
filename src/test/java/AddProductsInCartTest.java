import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.ProductsPage;
import pageObject.ViewCartPage;

import java.io.IOException;

public class AddProductsInCartTest extends BasePage {
    public AddProductsInCartTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver=getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver=null;
    }

    @Test
    public void addProducts() throws InterruptedException {
        HomePage home = new HomePage(driver);
        //Home Page is opening successfully
        Assert.assertEquals(home.getTitle(),"Automation Exercise");
        home.getProductsButton().click();

        ProductsPage products = new ProductsPage(driver);
        Actions actions = new Actions(driver);
        WebElement firstProduct = products.getFirstProduct();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,450)");

        String firstProductPriceFromProductPage = products.getFirstProductPrice().getText();
        String secondProductPriceFromProductPage = products.getSecondProductPrice().getText();
        actions.moveToElement(firstProduct).moveToElement(products.getFirstProductAddToCartButton()).click().build().perform();
        products.getFirstProductAddToCartButton().click();
        products.getContinueShoppingButton().click();

        WebElement secondProduct = products.getSecondProduct();
        actions.moveToElement(secondProduct).moveToElement(products.getSecondProductAddToCartButton()).click().build().perform();
        products.getSecondProductAddToCartButton().click();
        products.getViewCartButton().click();

        ViewCartPage cartPage = new ViewCartPage(driver);
        String firstProductPriceFromCartPage = cartPage.getFirstPrice().getText();
        String secondProductPriceFromCartPage = cartPage.getSecondPrice().getText();
        String firstProductQuantity = cartPage.getFirstQuantity().getText();
        String secondProductQuantity = cartPage.getSecondQuantity().getText();
        String firstTotalPrice = cartPage.getFirstTotal().getText();
        String secondTotalPrice = cartPage.getSecondTotal().getText();

        int firstPrice = Integer.parseInt(firstProductPriceFromProductPage.replaceAll("[Rs. ,]",""));
        int firstTotal = Integer.parseInt(firstTotalPrice.replaceAll("[Rs. ,]",""));
        int secondPrice = Integer.parseInt(secondProductPriceFromProductPage.replaceAll("[Rs. ,]",""));
        int secondTotal = Integer.parseInt(secondTotalPrice.replaceAll("[Rs. ,]",""));

        //Verifying Prices
        Assert.assertEquals(firstProductPriceFromCartPage,firstProductPriceFromProductPage);
        Assert.assertEquals(secondProductPriceFromCartPage,secondProductPriceFromProductPage);
        //Verifying Quantities
        Assert.assertEquals(Integer.parseInt(firstProductQuantity),1);
        Assert.assertEquals(Integer.parseInt(secondProductQuantity),1);
        //Verifying Total Prices
        Assert.assertEquals(firstPrice*Integer.parseInt(firstProductQuantity),firstTotal);
        Assert.assertEquals(secondPrice*Integer.parseInt(firstProductQuantity),secondTotal);
    }
}
