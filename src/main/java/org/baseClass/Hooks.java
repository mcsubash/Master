package org.baseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void launchBrowser() {

		browserLaunch("chrome");

	}

	@After (order = 1)
	public void failedScenarioScreenshot(Scenario scenario) {

		if(scenario.isFailed()) {

			TakesScreenshot tk = (TakesScreenshot)driver;
			File srcLoc = tk.getScreenshotAs(OutputType.FILE);

			File des =new File("D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\Screenshot\\FailedScenarioScreenshot.png");
			try {
				FileUtils.copyFile(srcLoc, des);
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	@After (order = 0)

	public void quitBrowser() {
		driver.close();
	}



}
