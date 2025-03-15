package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptOperation {

	WebDriver driver;
	JavascriptExecutor js;

	public JavaScriptOperation(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void jsclick(WebElement ele) {
		js.executeScript("arguments[0].click()", ele);
	}

	public void jsScrollIntoView(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void jsScrollDown() {
		js.executeScript("window.scrollBy(0,500)");
	}

	public void jsEnterText(WebElement ele, String value) {
		js.executeScript("document.getElementById('" + ele + "').value='" + value + "';");
	}
}
