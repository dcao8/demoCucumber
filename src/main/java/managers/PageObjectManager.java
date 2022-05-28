package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {
    private WebDriver driver;
    private KoreDemoPage koreDemoPage;
    private InGamePage inGamePage;
    private DemoQaLoginPage demoQaLoginPage;
    private DemoQaProfilePage demoQaProfilePage;
    private DemoQaBookStorePage demoQaBookStorePage;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public KoreDemoPage getKoreDemoPage() {

        return (koreDemoPage == null) ? koreDemoPage = new KoreDemoPage(driver) : koreDemoPage;

    }

    public InGamePage getInGamePage() {

        return (inGamePage == null) ? inGamePage = new InGamePage(driver) : inGamePage;

    }

    public DemoQaLoginPage getDemoQaLoginPage() {

        return (demoQaLoginPage == null) ? demoQaLoginPage = new DemoQaLoginPage(driver) : demoQaLoginPage;

    }

    public DemoQaProfilePage getDemoQaProfilePage() {

        return (demoQaProfilePage == null) ? demoQaProfilePage = new DemoQaProfilePage(driver) : demoQaProfilePage;

    }

    public DemoQaBookStorePage getDemoQaBookStorePage() {

        return (demoQaBookStorePage == null) ? demoQaBookStorePage = new DemoQaBookStorePage(driver) : demoQaBookStorePage;

    }
}
