package OnlineTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru="); //enter url
		
		// 1. xpath: (2nd priority) 
		
		// absolute xpath should not be used:  html/body/div[1]/div[5]/div[2]/a
		// on;y relative xpath should be used: //*[@id='firstname']
//		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Elmurot");
//		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Yangiboev");
//		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("1870 Chessland Street, Apt 16");
		
		// 2. id: (1st priority) 
//		driver.findElement(By.id("firstname")).sendKeys("Elmurot");
//		driver.findElement(By.id("lastname")).sendKeys("Yangiboev");
		
		// 3. name: (3rd priority) 
		driver.findElement(By.name("firstname")).sendKeys("Elmurot");
		driver.findElement(By.name("lastname")).sendKeys("Yangiboev");
		
		// 4. linkText: This is only for links
//		driver.findElement(By.linkText("Sign in")).click();
		
		// 5. partialLinkText: not useful
//		driver.findElement(By.partialLinkText("How to pick")).click();
				
		
		// 6. cssSelector: (2nd priority)
		// if id is there --> #id
		// if name is there --> .name
		driver.findElement(By.cssSelector("#address1")).sendKeys("1870 Chessland Street, Apt 16");
		
		// 7. className: not useful (4th priority)
		driver.findElement(By.className("ancAsb")).click();

	}

}
