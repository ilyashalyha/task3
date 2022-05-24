package frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class BrowserFactory {

    public static WebDriver setUp(Browser.Browsers type) {
        WebDriver driver;
        switch (type) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForScriptLoad())));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForImplicitWait())));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForScriptLoad())));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForImplicitWait())));
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        return driver;

    }


}
