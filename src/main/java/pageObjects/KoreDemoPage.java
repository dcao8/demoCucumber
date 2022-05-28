package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testDataTypes.KoreDemoAccount;

public class KoreDemoPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".login-link")
    WebElement btnLogin;

    @FindBy(css = ".logout-link")
    WebElement btnLogout;

    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(css = "[class='btn btn-primary']")
    WebElement btnLoginOnPopup;

    public KoreDemoPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getTimeOut());
        PageFactory.initElements(driver, this);
    }

    public void navigateToKoreDemoPage(String brand) {
        driver.get("https://demo-kore7.aristx-external.net/" + brand);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".game")));
    }

    public void openLoginPopup() {
        btnLogin.click();
        wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
    }

    public void login(KoreDemoAccount koreDemoAccount) {
        txtEmail.sendKeys(koreDemoAccount.username);
        txtPassword.sendKeys(koreDemoAccount.password);
        btnLoginOnPopup.click();
    }

    public void fillUsernameAndPassword(){
    }

    public void verifyLoginSuccess() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='game']")));
        if (btnLogout.isEnabled())
            System.out.println("Login Success");
        else
            System.out.println("Login Failed");
    }

    public void launchVideoSlotGame(String gameName) {
        WebElement linkGame = driver.findElement(By.xpath("//a[text()='" + gameName + "']"));
        linkGame.click();
    }

    public void launchVideoPokerGame(String gameName) {
        WebElement linkGame = driver.findElement(By.xpath("//a[text()='" + gameName + "']"));
        linkGame.click();
    }

    public void launchKenoGame(String gameName) {
        WebElement linkGame = driver.findElement(By.xpath("//a[text()='" + gameName + "']"));
        linkGame.click();
    }
}
