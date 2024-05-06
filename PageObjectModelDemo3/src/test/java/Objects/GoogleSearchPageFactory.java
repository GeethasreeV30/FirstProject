package Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPageFactory {
	WebDriver driver;

	public GoogleSearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="APjFqb") public WebElement searchBox;
	@FindBy(xpath="(//input[@name='btnK'])[1]") public WebElement searchButton;
	//@FindBy(className="sVXRqc")public WebElement amazonLink;
	@FindBy(xpath="//a//h3[contains(text(),'Amazon.in')]") public WebElement amazonLink;
	
	public void searchGoogle(String searchInput) {
		try {
			searchBox.sendKeys(searchInput);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(1000);
			searchButton.click();
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

	public void amazonApplicationSearch() {
		try {
			amazonLink.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

}
