package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.ContextManager;
import managers.FileReaderManager;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.When;
import pageObjects.KoreDemoPage;
import cucumber.TestContext;
import testDataTypes.KoreDemoAccount;

public class KoreDemoPageSteps {

    KoreDemoPage koreDemoPage =  ContextManager.getTestContext().getPageObjectManager().getKoreDemoPage();

    @Given("^MP brand is launched$")
    public void mp_brand_is_launched() {
        koreDemoPage.navigateToKoreDemoPage(FileReaderManager.getInstance().getConfigReader().getBrand());
    }

    @When("^User login with valid \"([^\"]*)\"$")
    public void user_login_with_valid_account(String username) {
        koreDemoPage.openLoginPopup();
        KoreDemoAccount user=FileReaderManager.getInstance().getJsonReader().getUsernameByUsername(username);
        koreDemoPage.login(user);
        koreDemoPage.verifyLoginSuccess();
    }

    @When("^Launch \"([^\"]*)\" Keno game$")
    public void launch_keno_game(String gameName) {
        koreDemoPage.launchKenoGame(gameName);
    }

    @When("^Launch \"([^\"]*)\" Video Poker game$")
    public void launch_video_poker_game(String gameName) {
        koreDemoPage.launchVideoPokerGame(gameName);
    }

    @When("^Launch \"([^\"]*)\" Video Slot game$")
    public void launch_video_slot_game(String gameName) {
        koreDemoPage.launchVideoSlotGame(gameName);
    }


}