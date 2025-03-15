package Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	// ✅ Wait for visibility using By locator
	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// ✅ Wait for visibility using WebElement
	public WebElement waitForElementToBeVisible(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// ✅ Wait for element to be clickable using By locator
	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// ✅ Wait for element to be clickable using WebElement
	public WebElement waitForElementToBeClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
