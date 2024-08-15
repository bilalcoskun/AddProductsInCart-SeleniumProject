package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;

    By productsButton = By.xpath("//a[contains(.,'\uE8F8 Products')]");
    By cartsButton = By.xpath("//a[contains(.,'\uE8F8 Products')]");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getProductsButton(){
        return driver.findElement(productsButton);
    }
    public WebElement getCartsButton(){
        return driver.findElement(cartsButton);
    }
    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

}
