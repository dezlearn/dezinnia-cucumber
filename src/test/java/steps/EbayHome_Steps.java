package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.Common_Actions;
import actions.EbayHome_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps {
	Common_Actions common_actions;
	EbayHome_Actions ebayhome_actions;
	
	public EbayHome_Steps(Common_Actions common_actions, EbayHome_Actions ebayhome_actions) {
		this.common_actions = common_actions;
		this.ebayhome_actions = ebayhome_actions;
	}
	
	@Given("I am on Eaby Home Page")
	public void i_am_on_Eaby_Home_Page() {
	   common_actions.goToUrl("https://www.ebay.com/");
	}

	@When("I click on Advanced Link")
	public void i_click_on_Advanced_Link() {
	    ebayhome_actions.clickAdvancedLink();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_Advanced_Search_page() {
	    String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
	    String actUrl = common_actions.getCurrentPageUrl();
	    if (!expUrl.equals(actUrl)) {
	    	fail("Page does not navigae to expected page");
	    }
	}
	
	@When("I serach for {string}")
	public void i_serach_for_iPhone_11(String str1) throws Exception {
		ebayhome_actions.searchAnItem(str1);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}

	@Then("I validate atleast {int} search items present")
	public void i_validate_atleast_search_items_presentint (int count) {
	    int itemCountInt = ebayhome_actions.getSeatchItemsCount();
	    if(itemCountInt <= count) {
	    	fail("Less than 1000 results shown");
	    }
	}
	
	@When("I serach for {string} in {string} category")
	public void i_serach_for_in_category(String string, String string2) throws Exception {
		ebayhome_actions.searchAnItem(string);
		ebayhome_actions.selectCategoryOption(string2);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) throws Exception {
	   ebayhome_actions.clickOnLinkByText(string);
	   Thread.sleep(1000);
	}

	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
	    String actUrl = common_actions.getCurrentPageUrl();
	    String actTitle = common_actions.getCurrentPageTitle();
	    if (!actUrl.equals(url)) {
	    	fail("Page does navigate to expected url: " + url);
	    }
	    if (!actTitle.contains(title)) {
	    	fail("Title mismatch");
	    }
	}
}