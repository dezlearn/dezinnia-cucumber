package actions;

import org.openqa.selenium.WebDriver;

import steps.Common_Steps;

public class Common_Actions {
	
	private WebDriver driver;
	
	Common_Steps common_steps;
	
	public Common_Actions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	public void goToUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
}
