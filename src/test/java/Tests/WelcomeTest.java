package Tests;

import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Pages.Welcome;

public class WelcomeTest extends TestBase {

	@Test(enabled = false)
	public void RegisterUser() {
		driver.get("https://automationexercise.com/");
		Welcome wl = new Welcome(driver);
		wl.verifyTitle();
		wl.NewUser();
		wl.createUser();
	}

	@Test(priority = 2)
	public void loginwithExistingUSer() {
		LoginPage Lp = new LoginPage(driver);
		Lp.loginUser();
		Lp.ValidaLoggedUser();
	}
}
