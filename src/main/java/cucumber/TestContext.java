package cucumber;

import managers.PageObjectManager;
import managers.WebDriversManager;

public class TestContext {
    private WebDriversManager webDriversManager;
    private PageObjectManager pageObjectManager;

    public TestContext(){
        webDriversManager = new WebDriversManager();
        pageObjectManager = new PageObjectManager(webDriversManager.getDriver());
    }

    public WebDriversManager getWebDriversManager() {
        return webDriversManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}