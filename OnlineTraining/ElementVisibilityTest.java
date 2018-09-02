/* 1. isDisplayed() is the method used to verify the presence of a web element within the web page.
      The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the webpage.
   2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
   3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
   4. isEnabled() is primarily used with buttons.
   5. isSelected() is the method used to verify if the web element is selected or not.
   6. isSelected() method is predominantly used with radio buttons, dropdowns and checkboxes. */

package OnlineTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch Chrome
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/register/");
		
		// 1. isDisplayed() method: applicable for all the elements
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed(); // for submit button
		System.out.println(b1); // true
		
		// 2. isEnabled() method:
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2); // false
		
		// select "I agree" checkbox:
		driver.findElement(By.name("agreeTerms")).click();
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b3); // true
		
		// 3. isSelected() method: only applicable for checkbox, dropdown, radiobutton
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4); // true
		
		// de-select the checkbox:
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b5); // false

	}

}
