package steam.tests.forms;

import frame.BaseForm;
import frame.elements.Block;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ActionPage extends BaseSteamPage {

    private final String recommendedSpecialsDiscountLocator = "//div[@class='discount_block  discount_block_inline']/div[@class='discount_pct']";
    private String requiredSpecialsDiscountLocator = "//div[@class='discount_block discount_block_inline']/div[@class='discount_pct']*[%s]";
    private String requiredAloneDiscountLocator = "//div[@class='discount_pct' and contains(text(), '%s')]";

    private int maxDiscount = 0;
    public String maxDiscountValue = String.valueOf(getMaxDiscount());



    public void selectMaxDiscount() {

        if (getDiscountArrayLengths() > 1) {
            moveToElementByDriver(requiredSpecialsDiscountLocator, String.valueOf(Math.random() * getDiscountArrayLengths()));
        } else if (getDiscountArrayLengths() == 1) {
            moveToElementByDriver(requiredAloneDiscountLocator, String.valueOf(maxDiscount));
        }

    }

    public int[] findMaxDiscount() {
        waitForElement();
        List<WebElement> allDiscounts = findElements(recommendedSpecialsDiscountLocator);
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
        return new int[] {maxDiscount, allDiscounts.size()};
    }

    public String getMaxDiscount() {
        return String.valueOf(findMaxDiscount()[0]);
    }

    public int getDiscountArrayLengths() {
        return findMaxDiscount()[1];
    }

}
