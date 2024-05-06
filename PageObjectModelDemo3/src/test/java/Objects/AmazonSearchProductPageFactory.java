package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchProductPageFactory {
	WebDriver driver;

	public AmazonSearchProductPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox") public WebElement searchBox;
	@FindBy(id="nav-search-submit-button") public WebElement searchButton;
	
	public void searchProduct(String productInput) {
		searchBox.sendKeys(productInput);
		searchButton.click();
	}
}
