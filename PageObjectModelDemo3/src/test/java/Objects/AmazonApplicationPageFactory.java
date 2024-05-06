package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonApplicationPageFactory {
	WebDriver driver;

	public AmazonApplicationPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="nav-link-accountList") public WebElement signInUrlButton;
	@FindBy(xpath="//div/h1[contains(text(),' Sign in')]") public WebElement verifyLoginUrlPage;
	@FindBy(id="ap_email") public WebElement phone;
	@FindBy(xpath="//input[@id='continue']") public WebElement continueButton;
	@FindBy(id="ap_password") public WebElement password;
	@FindBy(id="signInSubmit") public WebElement signInButton;
	@FindBy(id="nav-link-accountList-nav-line-1") public WebElement verifyUserName;
	
	public void loginUrl() {
		try {
			signInUrlButton.click();
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void verifyLoginPage() {
		try {
			String verify = verifyLoginUrlPage.getText();
			Assert.assertEquals(verify, "Sign in");
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void enterPhone(String phoneNoInput) {
		try {
			phone.sendKeys(phoneNoInput);
			continueButton.click();
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void enterPassword(String passwordInput) {
		try {
			password.sendKeys(passwordInput);
			signInButton.click();
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}
	}

	public void verifyUserNameAfterLogin(String expectedUserName) {
		try {
			String actualUsername = verifyUserName.getText();
			Assert.assertEquals(actualUsername, expectedUserName);
		} catch (Exception e) {
			System.out.println("Exception cought: " + e.getMessage());
		}

	}
}
