package steam.tests;

import steam.tests.forms.BaseSteamPage;
import frame.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import steam.tests.forms.ActionPage;

public class forExperiments extends BaseTest {

    public void runTest(String parameter) {
        browser.navigate("https://store.steampowered.com/");
        BaseSteamPage baseSteamPage = new BaseSteamPage();
        baseSteamPage.navigateMenu("Categories", "Action");
        ActionPage actionPage = new ActionPage();


        Assert.assertEquals("-75%$9.99$2.49 USD", browser.getDriver().findElement(By.xpath("//div[@class='discount_block discount_block_inline']")).getText());

    }
}