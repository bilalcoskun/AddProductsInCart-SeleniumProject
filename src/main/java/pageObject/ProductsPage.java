package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    public WebDriver driver;

    By firstProduct = By.xpath("//img[@src='/get_product_picture/1']");
    By firstProductAddToCartButton = By.xpath("(//a[@data-product-id='1'][contains(.,'Add to cart')])[2]");

    By secondProduct = By.xpath("//img[@src='/get_product_picture/2']");
    By secondProductAddToCartButton = By.xpath("(//a[@data-product-id='2'][contains(.,'Add to cart')])[2]");

    By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block'][contains(.,'Continue Shopping')]");

    By viewCartButton = By.xpath("//u[contains(.,'View Cart')]");

    By firstProductPrice = By.cssSelector("div.container div.row div.col-sm-9.padding-right div.features_items div.col-sm-4:nth-child(3) div.product-image-wrapper div.single-products div.productinfo.text-center > h2:nth-child(2)");
    By secondProductPrice = By.cssSelector("div.container div.row div.col-sm-9.padding-right div.features_items div.col-sm-4:nth-child(4) div.product-image-wrapper div.single-products div.productinfo.text-center > h2:nth-child(2)");
    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getFirstProduct(){
        return driver.findElement(firstProduct);
    }
    public WebElement getFirstProductAddToCartButton(){
        return driver.findElement(firstProductAddToCartButton);
    }
    public WebElement getSecondProduct(){
        return driver.findElement(secondProduct);
    }
    public WebElement getSecondProductAddToCartButton(){
        return driver.findElement(secondProductAddToCartButton);
    }

    public WebElement getContinueShoppingButton(){
        return driver.findElement(continueShoppingButton);
    }

    public WebElement getViewCartButton(){
        return driver.findElement(viewCartButton);
    }

    public WebElement getFirstProductPrice(){
        return driver.findElement(firstProductPrice);
    }
    public WebElement getSecondProductPrice(){
        return driver.findElement(secondProductPrice);
    }
}
