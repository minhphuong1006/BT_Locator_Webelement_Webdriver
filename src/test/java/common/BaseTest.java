package common;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
   public static WebDriver driver;
    public static void createBrowser (){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void createBrowser (String browserName){
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }
        if(browserName.equals("edge")){
            driver = new EdgeDriver();
        } else if(browserName.equals("firefox"))
        {
            driver=  new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void closeBrowser()
    {
        driver.quit();
    }

    public static void sleep (double second)
    {
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
