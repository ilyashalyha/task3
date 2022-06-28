package steam.pageObject;

import framework.elements.Block;
import framework.elements.Button;
import framework.elements.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class AgeForm extends BaseSteamPage{

    private static Block blkEnterBirthDate = new Block(By.xpath("//div[@class='agegate_birthday_desc']"), "enter birth date block");
    private Dropdown drdAgeYear = new Dropdown(By.id("ageYear"), "age year dropdown");
    private Dropdown drdPoint2003 = new Dropdown(By.xpath("//option[@value='2003']"), "dropdown point 2003");
    private Button btnViewProductPage = new Button(By.id("view_product_page_btn"), "view product page button");

    public AgeForm() {
        super(By.xpath(blkEnterBirthDate.getLocator()), "Age form page");
    }


    public boolean checkAgeFormAvailability() {
        try {
            return blkEnterBirthDate.isDisplayed();
        } catch (NoSuchElementException | NullPointerException e) {
            return false;
        }
    }

    public void checkForAgeForm() {
        if (checkAgeFormAvailability()) {
            drdAgeYear.click();
            drdPoint2003.click();
            btnViewProductPage.click();
        } else System.out.println("There is no age check");
    }
}
