package OnlineTraining;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver(); // launch Chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com/");

		// 1. get the total count of links on the page
		// 2. get the text of each link on the page

		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		List<WebElement> linkList2= driver.findElements(By.tagName("input"));
//		List<WebElement> linkList3= driver.findElements(By.tagName("button"));

		// size of linkList:
		System.out.println(linkList.size());
//		System.out.println(linkList2.size());
//		System.out.println(linkList3.size());
		for (int i = 0; i < linkList.size(); i++) {
			System.out.println(linkList.get(i).getText());
		}
	}
}
