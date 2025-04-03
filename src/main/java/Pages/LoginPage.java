package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.JavaScriptOperation;
import Base.PropertyReader;
import Base.WaitHelper;

public class LoginPage {
	WebDriver driver;
	WaitHelper wait;
	JavaScriptOperation js;
	PropertyReader prop = new PropertyReader();

	@FindBy(xpath = "//a[contains(text(),'Sign')]")
	private WebElement SignUpButton;
	@FindBy(xpath = "//input[@data-qa=\"login-email\"]")
	private WebElement UserEmail;
	@FindBy(xpath = "//input[@data-qa=\"login-password\"]")
	private WebElement LoginPassword;
	@FindBy(xpath = "//button[@data-qa=\"login-button\"]")
	private WebElement LoginButton;
	@FindBy(xpath = "//h2[text()=\"Login to your account\"]")
	private WebElement LogintabMessage;
	@FindBy(xpath = "//li//a[contains(text(),'Logged')]")
	private WebElement loggedUserMEssage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WaitHelper(driver);
		this.js = new JavaScriptOperation(driver);
	}

	public void loginUser() {
		SignUpButton.click();
		wait.waitForElementToBeVisible(LogintabMessage, 20);
		assertTrue(LogintabMessage.isDisplayed());
		UserEmail.sendKeys(prop.getProperty("NewUserEmail"));
		LoginPassword.sendKeys(prop.getProperty("NewUserPassword"));
		LoginButton.click();
	}

	public void ValidaLoggedUser() {
		String Actual = loggedUserMEssage.getText();
		String Expected = "Logged in as" + " " + prop.getProperty("NewUserName");
		Assert.assertEquals(Actual, Expected);
	}

	public void InvalidaLoggedUser() {
		SignUpButton.click();
		wait.waitForElementToBeVisible(LogintabMessage, 20);
		assertTrue(LogintabMessage.isDisplayed());
		UserEmail.sendKeys(prop.getProperty("invalidEmail"));
		LoginPassword.sendKeys(prop.getProperty("NewUserPassword"));
//		String Expected = "Logged in as" + " " + prop.getProperty("invalidEmail");

		LoginButton.click();
	}

}
