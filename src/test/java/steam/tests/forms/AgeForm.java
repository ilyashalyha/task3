package steam.tests.forms;

import frame.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static frame.Browser.driver;

public class AgeForm extends BaseForm {

    public boolean checkAgeFormAvailability() {
        try {
            return driver.findElement(By.xpath("//div[@class='agegate_birthday_desc']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void checkForAgeForm() {
        if (checkAgeFormAvailability()) {
            driver.findElement(By.id("ageYear")).click();
            driver.findElement(By.xpath("//option[@value='2003']")).click();
            driver.findElement(By.id("view_product_page_btn")).click();
        } else System.out.println("There are no age check");

    }
}
