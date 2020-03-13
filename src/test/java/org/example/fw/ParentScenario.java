package org.example.fw;


import org.example.pages.LandingPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ParentScenario {

	private WebDriver driver;
	protected static LandingPage landingPage;

	public void startChrome() {

		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Exception when registering the Driver " + e);
		}

		landingPage = new LandingPage(driver);

	}

	protected void closeDriver() {
		if (driver != null) {
			try {
				
				driver.close();
				driver.quit();

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}
}