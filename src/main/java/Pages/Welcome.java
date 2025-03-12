package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Welcome {
	WebDriver driver;

	// Locators using @FindBy annotation
	@FindBy(id = "username")
	private WebElement usernameField;

	public Welcome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyTitle() {
		String ET = "Automation Exercise";
		String AT = driver.getTitle();
		Assert.assertEquals(ET, AT);
	}
}
