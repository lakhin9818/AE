package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	protected WebDriver driver;

	@BeforeClass
	public void launch() {

//		System.setProperty("WebDriver.chrome.driver", "D:\\lakhin\\SeleniumPractice\\browser");
		ChromeOptions CO = new ChromeOptions();
		CO.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(CO);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(enabled = false)
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
