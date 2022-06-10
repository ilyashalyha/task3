package steam.tests.forms;

import frame.BaseForm;
import frame.elements.Block;
import frame.elements.Button;
import frame.elements.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static frame.Browser.driver;

public class AgeForm extends BaseSteamPage{

    private Block blkEnterBirthDate = new Block(By.xpath("//div[@class='agegate_birthday_desc']"), "enter birth date block");
    private Dropdown drdAgeYear = new Dropdown(By.id("ageYear"), "age year dropdown");
    private Dropdown drdPoint2003 = new Dropdown(By.xpath("//option[@value='2003']"), "dropdown point 2003");
    private Button btnViewProductPage = new Button(By.id("view_product_page_btn"), "view product page button");

    public boolean checkAgeFormAvailability() {
        try {
            return blkEnterBirthDate.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void checkForAgeForm() {
        if (checkAgeFormAvailability()) {
            drdAgeYear.click();
            drdPoint2003.click();
            btnViewProductPage.click();
        } else System.out.println("There are no age check");
    }
}
