package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "gotoStore")
    WebElement btnGoToBookStore;

    public DemoQaProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getTimeOut());
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfilePage() {
        driver.get("https://demoqa.com/profile");
        wait.until(ExpectedConditions.elementToBeClickable(btnGoToBookStore));
    }

    public boolean verifyBookIsDisplayedInCollection(String bookName) {
        if (driver.findElements(By.xpath("//*[@class='action-buttons']//*[text()='" + bookName + "']")).size() > 0)
            return true;
        else
            return false;
    }
}
