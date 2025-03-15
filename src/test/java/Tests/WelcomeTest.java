package Tests;

import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Welcome;

public class WelcomeTest extends TestBase {

	@Test
	public void homePage() {
		driver.get("https://automationexercise.com/");
		Welcome wl = new Welcome(driver);
		wl.verifyTitle();
		wl.NewUser();
	}
}
