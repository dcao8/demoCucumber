package stepDefinitions;

import apiRequests.DemoQaAccountAPI;
import apiRequests.DemoQaBookAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.ContextManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DemoQaBookStorePage;
import pageObjects.DemoQaLoginPage;
import pageObjects.DemoQaProfilePage;

import java.util.ArrayList;
import java.util.List;

public class demoQaPageSteps {

    DemoQaLoginPage demoQaLoginPage = ContextManager.getTestContext().getPageObjectManager().getDemoQaLoginPage();
    DemoQaProfilePage demoQaProfilePage = ContextManager.getTestContext().getPageObjectManager().getDemoQaProfilePage();
    DemoQaBookStorePage demoQaBookStorePage = ContextManager.getTestContext().getPageObjectManager().getDemoQaBookStorePage();
    DemoQaAccountAPI demoQaAccountAPI=new DemoQaAccountAPI();
    DemoQaBookAPI demoQaBookAPI=new DemoQaBookAPI();

    String book = "";
    List<String> listBooks = new ArrayList<String>();

    @Given("register new account")
    public void register_new_account() {
        demoQaAccountAPI.registerAccount();
    }

    @Then("delete account")
    public void delete_account() {
        demoQaAccountAPI.generateToken();
        demoQaAccountAPI.deleteAccount();
    }

    
    @Given("the user logs into application")
    public void the_user_logs_into_application() {
        demoQaLoginPage.navigateToLoginPage();
        demoQaLoginPage.login(demoQaAccountAPI.getUsername(), demoQaAccountAPI.getPassword());
    }

    
    @Given("the user is on Book Store page")
    public void the_user_is_on_Book_Store_page() {
        demoQaBookStorePage.navigateToBookStorePage();
        Assert.assertTrue(demoQaBookStorePage.isBookStorePage(), "This is not Book Store page");
    }

    
    @When("the user selects a book {string}")
    public void the_user_selects_a_book(String bookName) {
        demoQaBookStorePage.selectBook(bookName);
        book = bookName;
    }

    
    @When("the user clicks on Add To Your Collection")
    public void the_user_clicks_on_Add_To_Your_Collection() throws Exception {
        demoQaBookStorePage.clickAddToYourCollectionButton();
    }

    
    @Then("an alert “Book added to your collection.” is shown")
    public void an_alert_Book_added_to_your_collection_is_shown() {
        Assert.assertTrue(demoQaBookStorePage.verifyAlertAfterAddBook());
    }

    
    @Then("book is shown in your profile")
    public void book_is_shown_in_your_profile() {
        demoQaProfilePage.navigateToProfilePage();
        Assert.assertTrue(demoQaProfilePage.verifyBookIsDisplayedInCollection(book), book + "book is not displayed in Collection");
    }

    @Given("there are books named {string} and {string}")
    public void there_are_books_named_Learning_JavaScript_Design_Patterns_and_Designing_Evolvable_Web_APIs_with_ASP_NET(String book1, String book2) {
        this.removeAllListBook();
        listBooks.add(book1);
        listBooks.add(book2);
    }

    @When("the user input book name “Design” or {string}")
    public void the_user_input_book_name_Design_or(String keyword) {
        demoQaBookStorePage.inputBookNameToSearch(keyword);
    }

    @Then("all books match with input criteria will be displayed.")
    public void all_books_match_with_input_criteria_will_be_displayed() {

    }

    @Given("there is book named “Learning JavaScript Design Patterns”")
    public void there_is_book_named_Learning_JavaScript_Design_Patterns() {


    }

    @Given("the user is on Profile page")
    public void the_user_is_on_Profile_page() {


    }

    @When("the user search book “Learning JavaScript Design Patterns”")
    public void the_user_search_book_Learning_JavaScript_Design_Patterns() {


    }

    @When("the user clicks on Delete icon")
    public void the_user_clicks_on_Delete_icon() {


    }

    @When("the user clicks on OK button")
    public void the_user_clicks_on_OK_button() {


    }

    @When("the user clicks on OK button of alert “Book deleted.”")
    public void the_user_clicks_on_OK_button_of_alert_Book_deleted() {


    }

    @When("the book is not show")
    public void the_book_is_not_show() {


    }

    public void removeAllListBook() {
        if (!listBooks.isEmpty()) {
            for (String item : listBooks) {
                listBooks.remove(item);
            }
        }
    }
}
