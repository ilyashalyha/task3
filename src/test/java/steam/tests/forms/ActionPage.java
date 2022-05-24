package steam.tests.forms;

import frame.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static frame.Browser.driver;

public class ActionPage extends BaseForm {

    private final String recommendedSpecialsDiscountLocator = "//div[@class='discount_block  discount_block_inline']/div[@class='discount_pct']";
    private String requiredSpecialsDiscountLocator = "//div[@class='discount_block discount_block_inline']/div[@class='discount_pct']*[%s]";
    private String requiredAloneDiscountLocator = "//div[@class='discount_pct' and contains(text(), '%s')]";
    private int maxDiscount = 0;
    Actions actions = new Actions(driver);

    public void selectMaxDiscount() {

        List<WebElement> allDiscounts = driver.findElements(By.xpath(recommendedSpecialsDiscountLocator));
        int j = 0;
        do {
            for (int i = 0; i < allDiscounts.size(); i++) {

                String onlyDiscountValue = allDiscounts.get(i).getText().substring(1, 3);
                int price = Integer.parseInt(onlyDiscountValue);
                if (price > maxDiscount) {
                    maxDiscount = price;
                } else if (maxDiscount > price) {
                    allDiscounts.remove(i);
                    i--;
                }
            }
            j++;
        } while (j < 2);

        if (allDiscounts.size() > 1) {
            actions.moveToElement(driver.findElement(By.xpath(String.format(requiredSpecialsDiscountLocator, Math.random() * allDiscounts.size()))))
                    .click().build().perform();

        } else if (allDiscounts.size() == 1) {
            actions.moveToElement(driver.findElement(By.xpath(String.format(requiredAloneDiscountLocator, maxDiscount))))
                    .click().build().perform();
        }


    }


}
