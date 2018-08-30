package OnlineTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch Chrome
		
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0); // switch to frame if it's present
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();
		

	}

}
