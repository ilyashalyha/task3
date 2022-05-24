package frame;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseEntity {
    public static Browser browser;

    @BeforeTest
    public void before() {
        browser = Browser.getInstance();
        //if (browser != null) {
        //    browser.windowMaximise();
        //}

    }

    @AfterTest
    public void after() {
        if (browser.isBrowserAlive()) {
            //browser.exit();
        }
    }
}
