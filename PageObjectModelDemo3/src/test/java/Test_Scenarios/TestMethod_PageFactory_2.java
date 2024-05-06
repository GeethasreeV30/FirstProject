package Test_Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.AmazonApplicationPageFactory;
import Objects.GoogleSearchPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod_PageFactory_2 {
	WebDriver driver;
	GoogleSearchPageFactory pageFactory;
	AmazonApplicationPageFactory amazonPageFactory;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}
}
