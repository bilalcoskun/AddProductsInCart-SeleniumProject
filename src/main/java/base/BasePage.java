package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        InputStream data=new FileInputStream("src/main/resources/config.properties");
        prop.load(data);
    }

    public WebDriver getDriver() throws IOException{
        if(prop.getProperty("browser").equals("chrome")){
            driver = new ChromeDriver();
        }else if(prop.getProperty("browser").equals("firefox")){
            driver=new FirefoxDriver();
        }else{
            driver=new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getUrl() throws IOException{
        url=prop.getProperty("url");
        return url;
    }

}
