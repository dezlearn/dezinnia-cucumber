package steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Common_Steps {
	
	private WebDriver driver;
	
	@Before(order = 0)
	public void setUp() {
		 System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
		 driver = new ChromeDriver();
		 System.out.println("Global Before Hook Executed");
	}
	
	@After(order = 1)
	public void tearDown() throws Exception {
		driver.quit();
		Thread.sleep(1000);
		System.out.println("Global After Hook Executed");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}