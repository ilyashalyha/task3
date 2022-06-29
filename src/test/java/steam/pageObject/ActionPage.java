package steam.pageObject;

import framework.elements.Block;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ActionPage extends BaseSteamPage {
    private int maxDiscount = 0;
    private Block blkRecommendedSpecialsDiscount = new Block(By.xpath("//div[@class='salepreviewwidgets_StoreSaleDiscountBox_2fpFv']"), "discount block");
    private String requiredSpecialsDiscountLocator = "//div[@class='salepreviewwidgets_StoreSaleDiscountBox_2fpFv' and contains(text(), '%s')]";
    private String requiredAloneDiscountLocator = "//div[@class='salepreviewwidgets_StoreSaleDiscountBox_2fpFv' and contains(text(), '%s')]";
    private static Label lblActionsHeader = new Label(By.xpath("//div[@class='contenthubmaincarousel_ContentHubTitle_9tb4j ContentHubTitle']"), "Actions heaqder");
    private Block blkRequiredSpecialsDiscounts = new Block(By.xpath(String.format(requiredSpecialsDiscountLocator,
            Math.random() * getDiscountArrayLengths())), "all required blocks with discounts");
    private Block blkRequiredAloneDiscount = new Block(By.xpath(String.format(requiredAloneDiscountLocator,
            maxDiscount)), "alone block with max discount");
    public String maxDiscountValue = String.valueOf(getMaxDiscount());

    public ActionPage() {
        super(By.xpath(lblActionsHeader.getLocator()), "Actions header");
    }

    public void selectMaxDiscount() {
        if (getDiscountArrayLengths() > 1) {
            blkRequiredSpecialsDiscounts.clickViaJS();
        } else if (getDiscountArrayLengths() == 1) {
            blkRequiredAloneDiscount.clickViaJS();
        }
    }

    public int[] findMaxDiscount() {
        List<WebElement> allDiscounts = blkRecommendedSpecialsDiscount.findElements();
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