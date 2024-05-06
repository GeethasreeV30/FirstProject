package Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterProductPricePageFactory {
	WebDriver driver;

	public FilterProductPricePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="s-result-sort-select") public WebElement selectFilter;
	//@FindBy(xpath="//span[@class='a-price-whole']") public List<WebElement> priceAfterFilter;
	
	
	public void filterSelect(String value) {
		Select filter = new Select(selectFilter);
		filter.selectByValue(value);
	}
}
