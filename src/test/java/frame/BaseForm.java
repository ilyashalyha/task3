package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static frame.BaseTest.browser;

public class BaseForm extends Browser{

    public Actions actions = new Actions(driver);

    public void checkOpenedPageByTitle(String title) {
        String titleLocator = "//h2[@class='pageheader']";
        Assert.assertEquals(driver.findElement(By.xpath(titleLocator)).getText(), title);
    }

    public void checkOpenedPageByText(String value, String res) {
        Assert.assertEquals(value, res);
    }



    public void assertIsOpenedPage(String locator) {
        Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());
    }

    public List<WebElement> findElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public WebElement findElementByStringFormat(String locator, String value) {
        return browser.getDriver().findElement(By.xpath(String.format(locator, value)));
    }

    public void moveToElement(String locator, String value) {
        actions.moveToElement(findElementByStringFormat(locator, value)).pause(Duration.ofMillis(500)).build().perform();
    }

    public void moveToElementAndClick(String locator, String value) {
        actions.moveToElement(findElementByStringFormat(locator, value)).click().build().perform();
    }

    public void moveToElementByDriver(String locator, String value) {
        findElementByStringFormat(locator, value).click();
    }

    public void waitForElement() {
        actions.pause(Duration.ofMillis(1000)).build().perform();
    }

    public File findDownloadedFile(String fileName) {
        File steamFileDir = new File(Paths.get("").toAbsolutePath().toString());

        boolean flag = false;
        File steamFile = null;
        for (int i = 0; i < Integer.parseInt(getTimeoutForDownloadFile()); i++) {
            File[] steamFileDirList = steamFileDir.listFiles();
            for (int j = 0; j < steamFileDirList.length; j++) {
                if (steamFileDirList[j].getName().equals(fileName)) {

                    flag = true;
                    steamFile = steamFileDirList[j];
                    break;
                }
            }
            if (!flag) {
                waitForElement();
            } else break;
        }

        return steamFile;
    }

    public boolean isFileDownloaded(String fileName) {
        boolean flag = false;
        long steamFileLength = 0;
        File steamFile = findDownloadedFile(fileName);
        for (int i = 0; i < Integer.parseInt(getTimeoutForDownloadFile()); i++) {
            if (steamFileLength < steamFile.length()) {
                steamFileLength = steamFile.length();
                waitForElement();
            } else if (steamFileLength == steamFile.length()) {
                flag = true;
            }
        }

        return flag;
    }


    public void checkFileNameAndKill(String fileName) {
        Assert.assertEquals(findDownloadedFile(fileName).getName(), fileName);
        if (findDownloadedFile(fileName).delete()) {
            System.out.println("File deleted");
        } else System.out.println("File not deleted");
    }

    protected static String getLocKey(final String key) {
        ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);

    }

    public String getLocaleValue(String locCode) {
        Locale locale = new Locale(locCode);
        ResourceBundle locBundle = ResourceBundle.getBundle("localization/loc", locale);
        return locBundle.getString("localValue");
    }





}
