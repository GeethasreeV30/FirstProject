package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonApplicationPage {
	WebDriver driver;

	public AmazonApplicationPage(WebDriver driver) {
		this.driver = driver;
	}

	By signInUrlButton = By.id("nav-link-accountList");
	By verifyLoginUrlPage = By.xpath("//div/h1[contains(text(),' Sign in')]");
	By phone = By.id("ap_email");
	By continueButton = By.xpath("//input[@id='continue']");
	By password = By.id("ap_password");
	By signInButton = By.id("signInSubmit");
	By verifyUserName = By.id("nav-link-accountList-nav-line-1");

	public void loginUrl() {
		try {
			driver.findElement(signInUrlButton).click();
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void verifyLoginPage() {
		try {
			String verify = driver.findElement(verifyLoginUrlPage).getText();
			Assert.assertEquals(verify, "Sign in");
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void enterPhone(String phoneNoInput) {
		try {
			driver.findElement(phone).sendKeys(phoneNoInput);
			driver.findElement(continueButton).click();
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void enterPassword(String passwordInput) {
		try {
			driver.findElement(password).sendKeys(passwordInput);
			driver.findElement(signInButton).click();
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void verifyUserNameAfterLogin(String expectedUserName) {
		try {
			String actualUsername = driver.findElement(verifyUserName).getText();
			Assert.assertEquals(actualUsername, expectedUserName);
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}

	}
}
