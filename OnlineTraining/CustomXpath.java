package OnlineTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver(); // launch Chrome
		
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com");
		
		// absolute xpath is not recommended
		//*[@id="header"]/div[2]/div[2]/a/svg
		// 1. performance issue: very slow
		// 2. not reliable
		// 3. can be changed at any time in the future.
		
//		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		
//		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
		
		driver.findElement(By.xpath("//input[contains(@class, 'gh-tb ui-autocomplete-input')]")).sendKeys("Java");
		
		// dynamic id: input
		// test_123
		// By.id("test_123")
		
		// starts-with
		// id = test_456
		// id = test_789
		// id = test_test_7890_test
		
		// ends-with
		// id = 1234_test_t
		// id = 23456_test_t
		// id = 6789_test_t
		
//		driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Test");
		
		// for links: custom xpath
		// all the links are represented by <a> html tag
		driver.findElement(By.xpath("//a[contains(text(), 'My Account')]")).click();
	}

}
