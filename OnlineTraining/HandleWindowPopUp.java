package OnlineTraining;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch Chrome

		driver.get("http://www.popuptest.com/goodpopups.html");

		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[2]")).click();

		Thread.sleep(2000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String ParentWindowId = it.next();
		System.out.println("parent window id: " + ParentWindowId);

		String childWindowId = it.next();
		System.out.println("child window id: " + childWindowId);

		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		System.out.println("Child window popup title: " + driver.getTitle());
		driver.close();

		driver.switchTo().window(ParentWindowId);
		Thread.sleep(2000);
		System.out.println("Parent window popup title: " + driver.getTitle());
		driver.close();
	}
}
