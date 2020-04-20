package actions;

import org.openqa.selenium.WebDriver;

import elements.EabyAdvancedSearch_Elements;
import elements.EbayHome_Elements;
import steps.Common_Steps;

public class EbayAdvancedSearch_Actions {
	
	private WebDriver driver;
	EabyAdvancedSearch_Elements ebayadvancedsearch_elements;
	
	public EbayAdvancedSearch_Actions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
		ebayadvancedsearch_elements = new 	EabyAdvancedSearch_Elements(driver);
	}
	
	public void clickOnEbayLogo() {
		ebayadvancedsearch_elements.ebayLogo.click();
	}
	
	public void enterSearchString(String string) {
		ebayadvancedsearch_elements.searchString.sendKeys(string);
	}
	
	public void enterExcludeString(String string) {
		ebayadvancedsearch_elements.excludeString.sendKeys(string);
	}
	
	public void enterMinPrice(String string) {
		ebayadvancedsearch_elements.minPrice.sendKeys(string);
	}
	
	public void enterMaxPrice(String string) {
		ebayadvancedsearch_elements.maxPrice.sendKeys(string);
	}
	
	public void clickOnSearchBtn() {
		ebayadvancedsearch_elements.srchBtn.click();
	}
	
}
