package frame;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public abstract class BaseTest {
    public static Browser browser;

    public abstract void runTest(String parameter);

    @BeforeTest
    public void before() {
        browser = Browser.getInstance();
    }
    @Parameters({"fileName"})
    @Test
    public void xTest(String fileName) {
        Class<? extends BaseTest> currentClass = this.getClass();
        runTest(fileName);
    }

    @AfterTest(alwaysRun = true)
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
