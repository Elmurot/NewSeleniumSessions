package OnlineTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		
		// WebDriver driver = new ChromeDriver(); // launch Chrome

		// HtmlUnitDriver is not available in Selenium 3.x version.
		// HtmlUnitDriver -- to use this concept, we have to download HtmlUnitDriver JAR file
		// It's called Ghost Driver -- Headless Browser
		// -- HtmlUnitDriver -- Java
		// -- PhantomJS -- JavaScript

		// Advantages:
		// 1. testing is happening behind the scene -- now browser is launched
		// 2. Very fast -- execution of test cases -- very fast -- performance of the
		// script

		// Limitations:
		// Not suitable for Actions class -- user actions -- MouseMovement, doubleclick,
		// drag and drop

		WebDriver driver = new HtmlUnitDriver(); // launch Chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com");
		System.out.println("Before login, title is: === " + driver.getTitle());

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println("After login, title is: === " + driver.getTitle());

	}

}
