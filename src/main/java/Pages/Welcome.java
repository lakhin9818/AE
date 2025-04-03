package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.JavaScriptOperation;
import Base.PropertyReader;
import Base.WaitHelper;

public class Welcome {
	WebDriver driver;
	PropertyReader prop = new PropertyReader();
	WaitHelper wait;
	JavaScriptOperation js;

	// Locators using @FindBy annotation
	@FindBy(xpath = "//a[contains(text(),'Sign')]")
	private WebElement SignUpButton;

	@FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
	private WebElement NewUserSignupText;
	@FindBy(xpath = "//input[contains(@data-qa,'signup-name')]")
	private WebElement NewUserName;
	@FindBy(xpath = "//input[contains(@data-qa,\"signup-email\")]")
	private WebElement NewUserEmail;
	@FindBy(xpath = "//button[contains(text(),'Signup')]")
	private WebElement NewUserSignUpButton;
	@FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
	private WebElement VerifyEmailExist;
	@FindBy(xpath = "data-qa=\"login-email\"")
	private WebElement LoginExistinguser;
	@FindBy(xpath = "//input[contains(@id,'id_gender1')]")
	private WebElement GenderMrSelect;
	@FindBy(xpath = "//input[@name=\"first_name\"]")
	private WebElement SignUpFirstName;
	@FindBy(xpath = "//input[@name=\"last_name\"]")
	private WebElement SignUpLastName;
	@FindBy(xpath = "//input[@name=\"address1\"]")
	private WebElement SignUpAdress;
	@FindBy(id = "country")
	private WebElement signupCounty;
	@FindBy(id = "password")
	private WebElement NewUserPassword;
	@FindBy(id = "state")
	private WebElement SignUpState;
	@FindBy(id = "mobile_number")
	private WebElement SignUpMobile;
	@FindBy(id = "city")
	private WebElement SignUpCity;
	@FindBy(id = "zipcode")
	private WebElement SignUpZipcode;
	@FindBy(xpath = "//h2//b[contains(text(),'Enter Account Information')]")
	private WebElement UserDetailPage;
	@FindBy(xpath = "//button[contains(text(),'Create Acc')]")
	private WebElement CreateAccButton;
	@FindBy(xpath = "//h2//b[contains(text(),'Account Created')]")
	private WebElement AccoutCreatedMessage;

	public Welcome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WaitHelper(driver);
		this.js = new JavaScriptOperation(driver);
	}

	public void verifyTitle() {
		String ET = "Automation Exercise";
		String AT = driver.getTitle();
		Assert.assertEquals(ET, AT);
	}

	public void NewUser() {
		SignUpButton.click();
		wait.waitForElementToBeVisible(NewUserSignupText, 10);
		if (NewUserSignupText.isDisplayed()) {
			NewUserName.sendKeys(prop.getProperty("NewUserName"));
//			NewUserName.sendKeys("lakhin");
			NewUserEmail.sendKeys(prop.getProperty("NewUserEmail"));
			NewUserSignUpButton.click();

		} else {
			System.out.println("problem navigating to signup page");
			if (VerifyEmailExist.isDisplayed())

				LoginExistingUSer();

		}
	}

	public void LoginExistingUSer() {
		System.out.println("existing user login");
	}

	public void createUser() {
		wait.waitForElementToBeVisible(UserDetailPage, 20);
		Assert.assertTrue(UserDetailPage.isDisplayed());
		GenderMrSelect.click();
		js.jsclick(NewUserPassword);
		NewUserPassword.sendKeys(prop.getProperty("NewUserPassword"));
		SignUpFirstName.sendKeys(prop.getProperty("SignupFirstName"));
		SignUpLastName.sendKeys(prop.getProperty("SignupLastName"));
		SignUpAdress.sendKeys(prop.getProperty("SignupAdress"));
		js.jsScrollIntoView(signupCounty);
		Select country = new Select(signupCounty);
		country.selectByValue(prop.getProperty("SignupCountry"));
		SignUpState.sendKeys(prop.getProperty("SignUpState"));
		SignUpCity.sendKeys(prop.getProperty("SignUpCity"));
		SignUpZipcode.sendKeys(prop.getProperty("SignUpZipcode"));
		SignUpMobile.sendKeys(prop.getProperty("SignUpMobile"));
		CreateAccButton.click();
		String ACCreatedMSG = "ACCOUNT CREATED!";
		Assert.assertEquals(AccoutCreatedMessage.getText(), ACCreatedMSG);
	}
}
