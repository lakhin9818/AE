package Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

public class Listeners implements ITestListener {
//	WebDriver driver;

//
	@Override
	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");

	}

	@Override
	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass = result.getInstance();
		if (testClass instanceof TestBase) {
			WebDriver driver = ((TestBase) testClass).getDriver();

			if (driver != null) {
				System.out.println("✅ WebDriver is initialized. Capturing screenshot...");

				try {
					takeSnapShot(driver, result.getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println("🚨 WebDriver is NULL, cannot take screenshot.");
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped" + result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Method passed" + result.getName());

	}

	public static void takeSnapShot(WebDriver driver, String testName) throws Exception {
//		// Convert web driver object to TakeScreenshot
//		String ss = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//
//		String nameWithTime = ss + ".png";
////		TakesScreenshot scrShot = ((TakesScreenshot) driver);
//		// Call getScreenshotAs method to create image file
////		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File svd = new File(SrcFile);
//		String screenshotPath = ".Screenshots" + testName + "_" + nameWithTime;
//
//		// Move image file to new destination
//		File DestFile = new File(screenshotPath);
//		// Copy file at destination
//		FileUtils.copyFile(svd, DestFile);
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			if (srcFile.exists()) { // ✅ Ensure the file exists before copying
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				String screenshotPath = "D:\\lakhin\\AE\\Screenshots\\" + testName + "_" + timestamp + ".png";

				File destFile = new File(screenshotPath);
				FileUtils.copyFile(srcFile, destFile);
				System.out.println("✅ Screenshot saved at: " + screenshotPath);
			} else {
				System.out.println("🚨 Screenshot file does not exist! Skipping copy.");
			}

		} catch (IOException e) {
			System.out.println("🚨 Error while saving screenshot: " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("🚨 WebDriverException while taking screenshot: " + e.getMessage());
		}
	}

}
