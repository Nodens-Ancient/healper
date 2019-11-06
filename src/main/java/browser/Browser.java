package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Browser {
    private WebDriver driver;

    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        new ChromeOptions().addArguments("headless");
        driver = new ChromeDriver();
        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
       return driver;
    }
}
