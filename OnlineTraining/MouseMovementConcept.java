package OnlineTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch Chrome
		driver.get("https://www.yo-kart.com/");
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Features')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'Features Overview')]")).click();
//		driver.findElement(By.linkText("Raymond Murphy")).click();
	}

}
