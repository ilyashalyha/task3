package steam.tests;

import frame.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import steam.tests.forms.ActionPage;
import steam.tests.forms.MainPage;
import steam.tests.forms.Menu;

public class forExperiments extends BaseTest {

    public void runTest() {
        browser.navigate("https://store.steampowered.com/");
        //MainPage mainPage = new MainPage();
        //mainPage.setLocale("English");
        Menu menu = new Menu();
        menu.navigateMenu("Categories", "Action");
        ActionPage actionPage = new ActionPage();


        Assert.assertEquals("-75%$9.99$2.49 USD", browser.getDriver().findElement(By.xpath("//div[@class='discount_block discount_block_inline']")).getText());



    }
}