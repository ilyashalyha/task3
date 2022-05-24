package frame;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    public static WebDriver driver;
    private static Browser instance;
    static final String PROPERTIES_FILE = "conf.properties";
    private static final String BROWSER_PROP = "browser";
    public static PropertiesResourceManager props;
    private static final String DEFAULT_PAGE_LOAD_TIMEOUT = "pageLoadTimeout";
    private static final String DEFAULT_SCRIPT_LOAD_TIMEOUT = "scriptLoadTimeout";
    private static final String DEFAULT_IMPLICIT_TIMEOUT = "implicitWait";
    private static String timeoutForPageLoad;
    private static String timeoutForScriptLoad;
    private static String timeoutForImplicitWait;
    public static Browsers currentBrowser;

    public static String getBrowserProp() {
        return props.getProperty(BROWSER_PROP);
    }

    public static String getTimeoutForPageLoad() {
        return timeoutForPageLoad;
    }

    public static String getTimeoutForScriptLoad() {
        return timeoutForScriptLoad;
    }

    public static String getTimeoutForImplicitWait() {
        return timeoutForImplicitWait;
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }

    private static void initProperties() {
        props = new PropertiesResourceManager(PROPERTIES_FILE);
        currentBrowser = Browser.Browsers.valueOf(getBrowserProp().toUpperCase());

        timeoutForPageLoad = props.getProperty(DEFAULT_PAGE_LOAD_TIMEOUT);
        timeoutForScriptLoad = props.getProperty(DEFAULT_SCRIPT_LOAD_TIMEOUT);
        timeoutForImplicitWait = props.getProperty(DEFAULT_IMPLICIT_TIMEOUT);


    }

    public static Browser getInstance() {
        if (instance == null) {

            initProperties();
            driver = BrowserFactory.setUp(currentBrowser);
            instance = new Browser();
        }
        return instance;
    }



    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getTimeoutForPageLoad())));

        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d)
                            .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    return result instanceof Boolean && (Boolean) result;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public enum Browsers {
        /**
         * @uml.property name="FIREFOX"
         * @uml.associationEnd
         */
        FIREFOX("firefox"), /**
         * @uml.property name="CHROME"
         * @uml.associationEnd
         */
        CHROME("chrome");

        public String value;

        /**
         * Constructor
         * @param values Value
         */
        Browsers(final String values) {
            value = values;
        }

        /**
         * Returns string value
         * @return String value
         */
        public String toString() {
            return value;
        }
    }


    public void navigate(final String url) {
        driver.navigate().to(url);
        waitForPageToLoad();
    }

    public WebDriver getDriver() {
        return driver;
    }

}