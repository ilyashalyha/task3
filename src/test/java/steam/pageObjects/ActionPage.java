package steam.pageObjects;

import frame.elements.Block;
import frame.elements.InfoField;
import frame.elements.StringFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ActionPage extends BaseSteamPage {

    private Block recommendedSpecialsDiscountLocator = new Block(By.xpath("//div[@class='salepreviewwidgets_StoreSaleDiscountBox_2fpFv']"), "discount block");
    private StringFormat requiredSpecialsDiscountLocator = new StringFormat(By.xpath("//div[@class='salepreviewwidgets_StoreSaleDiscountBox_2fpFv' and contains(text(), '%s')]"), "template of discount locators");
    private StringFormat requiredAloneDiscountLocator = new StringFormat(By.xpath("//div[@class='salepreviewwidgets_StoreSaleDiscountBox_2fpFv' and contains(text(), '%s')]"), "template of required discount locator");
    private InfoField actionsHeader = new InfoField(By.xpath("//div[@class='contenthubmaincarousel_ContentHubTitle_9tb4j ContentHubTitle']"), "Actions heaqder");

    private int maxDiscount = 0;
    public String maxDiscountValue = String.valueOf(getMaxDiscount());

    public ActionPage() {
        super(driver);
    }

    public void checkOpenedPage() {
        assertIsOpenedPage(actionsHeader.getLocator());
    }

    public void selectMaxDiscount() {
        if (getDiscountArrayLengths() > 1) {
            requiredSpecialsDiscountLocator.moveToElementByJS(String.valueOf(Math.random() * getDiscountArrayLengths()));
        } else if (getDiscountArrayLengths() == 1) {
            requiredAloneDiscountLocator.moveToElementByJS(String.valueOf(maxDiscount));
        }
    }

    public int[] findMaxDiscount() {
        List<WebElement> allDiscounts = recommendedSpecialsDiscountLocator.findElements();
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