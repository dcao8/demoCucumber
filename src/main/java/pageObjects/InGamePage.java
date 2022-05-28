package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InGamePage {

    WebDriver driver;

    @FindBy(css = ".spin-btn")
    WebElement btnSpin;

    @FindBy(id = "deal-btn")
    WebElement btnDeal;

    @FindBy(id = "draw-btn")
    WebElement btnDraw;

    @FindBy(id = "collect-btn")
    WebElement btnCollect;

    @FindBy(id = "draw-btn")
    WebElement btnPlay;

    @FindBy(id = "clear-btn")
    WebElement btnClear;

    @FindBy(css = ".buttons .lobby-btn")
    WebElement btnHome;

    WebDriverWait wait;

    public InGamePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getTimeOut());
        PageFactory.initElements(driver, this);
    }

    public void playVideoSlotGame() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSpin)).click();
        System.out.println("Play Video Slot game success");
    }

    public void playVideoPokerGame() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHome));
        enableDealButton();
        wait.until(ExpectedConditions.elementToBeClickable(btnDeal)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnDraw)).click();
        System.out.println("Play Video Poker game success");
    }

    public void playKenoGame(String pickNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(btnHome));
        pickNumberInKenoGame(pickNumber);
        wait.until(ExpectedConditions.elementToBeClickable(btnPlay)).click();
        System.out.println("Play Keno game success");
    }

    public void pickNumberInKenoGame(String pickNumber) {
        String btnClearStatus = btnClear.getAttribute("class");
        if (!btnClearStatus.contains("disabled")) {
            btnClear.click();
            System.out.println("\nCleared");
            wait.until(ExpectedConditions.attributeContains(btnClear, "class", "disabled"));
        }
        driver.findElement(By.xpath("//*[@class='pick-number'][text()='" + pickNumber + "']/parent::div")).click();
    }

    public void enableDealButton() {
        String btnDealStatus = btnDeal.getAttribute("class");
        if (btnDealStatus.contains("disabled")) {
            if (!btnCollect.getAttribute("class").contains("disabled"))
                btnCollect.click();
            else if (!btnDraw.getAttribute("class").contains("disabled"))
                btnDraw.click();
        }


    }
}
