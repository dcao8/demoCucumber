package stepDefinitions;

import cucumber.TestContext;
//import cucumber.api.java.en.Then;
import io.cucumber.java.en.Then;
import managers.ContextManager;
import managers.FileReaderManager;
import org.testng.Assert;
import pageObjects.InGamePage;

public class InGamePageSteps {

    InGamePage inGamePage = ContextManager.getTestContext().getPageObjectManager().getInGamePage();

    @Then("^User can play Keno game successfully$")
    public void user_can_play_keno_game_successfully() {
        inGamePage.playKenoGame(FileReaderManager.getInstance().getConfigReader().getPickNumber());
        Assert.assertTrue(false);
    }

    @Then("^User can play Video Slot game successfully$")
    public void user_can_play_video_slot_game_successfully() {
        inGamePage.playVideoSlotGame();
        Assert.assertTrue(false);
    }

    @Then("^User can play Video Poker game successfully$")
    public void user_can_play_video_poker_game_successfully() {
        inGamePage.playVideoPokerGame();
    }
}
