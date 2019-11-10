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
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.setBinary("/usr/bin/chromium");
//      System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        if (ref != null){
            driver.get(ref);
        }
        return driver;
    }
}
