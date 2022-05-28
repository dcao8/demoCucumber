package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class DemoQaBookStorePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".books-wrapper .rt-table")
    WebElement tbBookStore;

    @FindBy(id = "searchBox")
    WebElement txtSearch;

    @FindBy(css = ".text-right #addNewRecordButton")
    WebElement btnAddToYourCollection;

    public DemoQaBookStorePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getTimeOut());
        PageFactory.initElements(driver, this);
    }

    public void navigateToBookStorePage() {
        driver.get("https://demoqa.com/books");
        wait.until(ExpectedConditions.elementToBeClickable(tbBookStore));
    }

    public boolean isBookStorePage() {
        if (driver.findElements(By.cssSelector(".books-wrapper")).size() > 0) {
            return true;
        } else
            return false;
    }

    public void selectBook(String bookName) {
        driver.findElement(By.xpath("//*[@class='action-buttons']//*[text()='" + bookName + "']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
    }

    public boolean verifyAlertAfterAddBook() {
        try {
            driver.switchTo().alert().accept();
            String alertText = driver.switchTo().alert().getText();
            if (alertText.contains("Book added to your collection."))
                return true;
            else {
                System.out.println("Alert Text: " + alertText);
                return false;
            }
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void inputBookNameToSearch(String bookName) {
        txtSearch.clear();
        txtSearch.sendKeys(bookName);
    }

    public List<String> getAvailableBooks() {
        List<String> listBookName = new ArrayList<String>();
        List<WebElement> listBooks = driver.findElements(By.cssSelector("[id*='see-book'] a"));
        for (WebElement item : listBooks) {
            listBookName.add(item.getText());
        }
        return listBookName;
    }

    public boolean verifyBooksAfterSearching(List<String> listBooks, String bookName) {
        if (listBooks.isEmpty()) {
            System.out.println("There is no book after searching.");
            return false;
        } else {
            int failedBookAmount = 0;
            for (String book : listBooks) {
                if (!book.contains(bookName)) {
                    failedBookAmount += 1;
                    System.out.println(book + " not contain the key work '" + bookName + "'");
                }
            }
            if (failedBookAmount > 0)
                return false;
            else return true;
        }
    }

    public boolean verifyBookIsDisplayedInBookStore(String bookName) {
        if (driver.findElements(By.xpath("//*[@class='action-buttons']//*[text()='" + bookName + "']")).size() > 0)
            return true;
        else
            return false;
    }

    public void clickAddToYourCollectionButton() throws Exception {
        btnAddToYourCollection.click();
        Thread.sleep(5000);
    }
}
