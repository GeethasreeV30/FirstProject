package Test_Scenarios;

import org.testng.annotations.Test;

import Objects.AmazonApplicationPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestMethod_GoogleSearch {
	WebDriver driver;
	GoogleSearchPage page;
	AmazonApplicationPage amazonPage;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void googleSearch(){
		page = new GoogleSearchPage(driver);
		page.searchGoogle("amazon");
	}
	
	@Test(priority=1)
	public void amazonURL() {
		page = new GoogleSearchPage(driver);
		page.amazonApplicationSearch();
	}
	@Test(priority=2)
	public void amazonLogin() {
		amazonPage= new AmazonApplicationPage(driver);
		amazonPage.loginUrl();
		amazonPage.verifyLoginPage();
		amazonPage.enterPhone("6302935810");
		amazonPage.enterPassword("bt07sv");
		amazonPage.verifyUserNameAfterLogin("Hello, Geethasree");
	}

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
