package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "login")
    WebElement btnLogin;

    @FindBy(id = "logout")
    WebElement btnLogout;

    @FindBy(id = "userName")
    WebElement txtUserName;

    @FindBy(id = "password")
    WebElement txtPassword;

    public DemoQaLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getTimeOut());
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://demoqa.com/login");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary")));
    }

    public void login(String userName, String password) {
        if (driver.findElements(By.cssSelector(".btn-primary")).size() > 1) {
            enterUserNameAndPassword(userName, password);
            wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
        }
    }

    public void enterUserNameAndPassword(String userName, String password) {
        txtUserName.clear();
        txtUserName.sendKeys(userName);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
}
