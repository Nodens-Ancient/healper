package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Browser {
    private String ref;
    public Browser(String ref){
        this.ref = ref;
    }
    public Browser(){

    }
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        new ChromeOptions().addArguments("headless");
        WebDriver driver = new ChromeDriver();
        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        if (ref != null){
            driver.get(ref);
        }
        return driver;
    }
}
