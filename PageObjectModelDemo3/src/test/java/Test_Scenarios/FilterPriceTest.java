package Test_Scenarios;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.AddToCartPageFactory;
import Objects.AmazonApplicationPageFactory;
import Objects.AmazonSearchProductPageFactory;
import Objects.FilterProductPricePageFactory;
import Objects.GoogleSearchPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterPriceTest {
	WebDriver driver;
	GoogleSearchPageFactory pageFactory;
	AmazonApplicationPageFactory amazonPageFactory;
	AmazonSearchProductPageFactory amazonSearchPageFactory;
	FilterProductPricePageFactory filterProductPageFsctory;
	AddToCartPageFactory addToCartPageFactory;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void googleSearch(){
		pageFactory = new GoogleSearchPageFactory(driver);
		pageFactory.searchGoogle("amazon");
	}
	
	@Test(priority=1)
	public void amazonURL() {
		pageFactory = new GoogleSearchPageFactory(driver);
		pageFactory.amazonApplicationSearch();
	}
	@Test(priority=2)
	public void amazonLogin() {
		amazonPageFactory= new AmazonApplicationPageFactory(driver);
		amazonPageFactory.loginUrl();
		amazonPageFactory.verifyLoginPage();
		amazonPageFactory.enterPhone("6302935810");
		amazonPageFactory.enterPassword("bt07sv");
		amazonPageFactory.verifyUserNameAfterLogin("Hello, Geethasree");
	}
	
	@Test(priority=3)
	public void searchProduct() {
		amazonSearchPageFactory = new AmazonSearchProductPageFactory(driver);
		amazonSearchPageFactory.searchProduct("Samsung S24 Ultra");	
	}
	
	@Test(priority=4)
	public void filterProductGet3rdProdct() {
		filterProductPageFsctory = new FilterProductPricePageFactory(driver);
		filterProductPageFsctory.filterSelect("price-asc-rank");
	}
	@Test(priority=5)
	public void addToCart() throws InterruptedException{
		addToCartPageFactory = new AddToCartPageFactory(driver);
		addToCartPageFactory.addToCartProduct();
	}
	@AfterTest
	public void afterTest() {
		//driver.quit();
	}
}
