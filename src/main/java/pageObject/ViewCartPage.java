package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewCartPage {
    public WebDriver driver;
    By firstPrice = By.xpath("//p[contains(.,'Rs. 500')]");
    By secondPrice = By.xpath("//p[contains(.,'Rs. 400')]");
    By firstQuantity = By.xpath("(//button[@class='disabled'][contains(.,'1')])[1]");
    By secondQuantity = By.xpath("(//button[@class='disabled'][contains(.,'1')])[2]");
    By firstTotal = By.xpath("//p[@class='cart_total_price'][contains(.,'Rs. 500')]");
    By secondTotal = By.xpath("//p[@class='cart_total_price'][contains(.,'Rs. 400')]");

    public ViewCartPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getFirstPrice(){
        return driver.findElement(firstPrice);
    }
    public WebElement getSecondPrice(){
        return driver.findElement(secondPrice);
    }
    public WebElement getFirstQuantity(){
        return driver.findElement(firstQuantity);
    }
    public WebElement getSecondQuantity(){
        return driver.findElement(secondQuantity);
    }
    public WebElement getFirstTotal(){
        return driver.findElement(firstTotal);
    }
    public WebElement getSecondTotal(){
        return driver.findElement(secondTotal);
    }
}
