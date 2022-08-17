package steps;

import static org.junit.Assert.fail; 

import org.openqa.selenium.WebDriver;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayAdvancedSearch_Steps {
	Common_Actions common_actions;
	EbayAdvancedSearch_Actions ebayadvancedsearch_actions;
	
	public EbayAdvancedSearch_Steps(Common_Actions common_actions, EbayAdvancedSearch_Actions ebayadvancedsearch_actions) {
		this.common_actions = common_actions;
		this.ebayadvancedsearch_actions = ebayadvancedsearch_actions;
	}
	
	@Given("I am Ebay Advanced Search Page")
	public void i_am_Ebay_Advanced_Search_Page() throws InterruptedException {
		common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
	}

	@When("I click on Ebay Logo")
	public void i_click_on_Ebay_Logo() {
		ebayadvancedsearch_actions.clickOnEbayLogo();
	}

	@Then("I am navigated to Ebay Home Page")
	public void i_am_navigated_to_Ebay_Home_Page() {
	    String expUrl = "https://www.ebay.com/";
	    String actUrl = common_actions.getCurrentPageUrl();
	    if (!expUrl.equals(actUrl)) {
	    	fail("Page does not naviage to home page");
	    }
	}
	
	@When("I advanced search an item")
	public void i_advanced_search_an_item(DataTable dataTable) throws Exception {
		ebayadvancedsearch_actions.enterSearchString(dataTable.cell(1, 0));
		ebayadvancedsearch_actions.enterExcludeString(dataTable.cell(1, 1));
		ebayadvancedsearch_actions.enterMinPrice(dataTable.cell(1, 2));
		ebayadvancedsearch_actions.enterMaxPrice(dataTable.cell(1, 3));
		ebayadvancedsearch_actions.clickOnSearchBtn();
	}
}
