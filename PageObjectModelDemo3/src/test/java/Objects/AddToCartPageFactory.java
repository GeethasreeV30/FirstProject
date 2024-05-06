package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPageFactory {
	WebDriver driver;

	public AddToCartPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"a-autoid-35-announce\"]") public WebElement addToCartButton;
	
	public void addToCartProduct() throws InterruptedException {
		Thread.sleep(2000);;
		addToCartButton.click();
	}
	

}
