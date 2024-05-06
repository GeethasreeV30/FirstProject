package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.id("APjFqb");
	By searchButton = By.xpath("(//input[@name='btnK'])[1]");
	By amazonLink = By.className("sVXRqc");
	

	public void searchGoogle(String searchInput) {
		try {
			driver.findElement(searchBox).sendKeys(searchInput);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(1000);
			driver.findElement(searchButton).click();
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

	public void amazonApplicationSearch() {
		try {
			driver.findElement(amazonLink).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
