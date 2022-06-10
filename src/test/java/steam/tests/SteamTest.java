package steam.tests;


import org.testng.annotations.Parameters;
import steam.tests.forms.BaseSteamPage;
import frame.BaseTest;
import steam.tests.forms.*;


public class SteamTest extends BaseTest {

    public void runTest(String fileName) {
        browser.navigate("https://store.steampowered.com/");
        MainPage mainPage = new MainPage();
        mainPage.setLocale("en");
        mainPage.navigateMenu("Categories", "Action");
        ActionPage actionPage = new ActionPage();
        actionPage.checkOpenedPageByTitle("Action");
        actionPage.selectMaxDiscount();
        AgeForm ageForm = new AgeForm();
        ageForm.checkForAgeForm();
        GamePage gamePage = new GamePage();
        gamePage.checkGamePage(actionPage.maxDiscountValue);
        gamePage.clickInstallSteamButton();
        InstallSteamPage installSteamPage = new InstallSteamPage();
        installSteamPage.checkInstallSteamPageOpened();
        installSteamPage.downloadSteam();
        installSteamPage.checkFileNameAndKill(fileName);
        //"SteamSetup.exe"

    }
}
