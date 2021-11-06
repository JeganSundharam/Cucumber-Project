package org.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.utilies.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {
	@Before(order = 1)
	public void launch() {
		launchbrowser();
		loadUrl("https://www.facebook.com/");
	}

	@Before(order = 2)
	public void StartTime() {
System.out.println("Test Start Time: ");
		TestStartTime();
	}

	@After(order = 2)
	public void endTime() {
		System.out.println("Test End Time: ");
		TestEndTime();
	}

	@After(order = 3)
	public void failScreenshot(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot ss=(TakesScreenshot)driver;
			byte[] screenshotAs = ss.getScreenshotAs(OutputType.BYTES);
			s.embed(screenshotAs, "image/png");
			
		}
		
	}
	@After(order = 4)
	public void screenshot(Scenario s) throws IOException {
		String name = s.getName();
		String imgName = name.replace(" ", "_");
		toScreenShot(imgName);
	}
	@After(order=1)
	public void browserClose() {
		driver.close();
	}

}
