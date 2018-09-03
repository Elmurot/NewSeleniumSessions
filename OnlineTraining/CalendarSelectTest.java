/*
 Steps to handle calendar in Selenium Webdriver:
 	1 - Click on calendar
 	2 - Get all td of tables using findElements method
 	3 - using for loop get text of all elements
 	4 - using if else condition we will check specific date
 	5 - If date is matched then click and break the loop. 
 	6 - Handle NoSuchElementException in case of (31st day)
 */

package OnlineTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com"); // enter URL
		Thread.sleep(3000);

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		driver.switchTo().frame("mainpanel");

		String date = "32-October-2018";
		String dateArr[] = date.split("-"); // {18, September, 2018}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText("October");

		Select select2 = new Select(driver.findElement(By.name("slctYear")));
		select2.selectByVisibleText("2018");
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		
		String before_xpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath = "]/td[";
		final int totalWeekDays = 7;
		
		// 2-1 2-2 2-3 2-4 2-5 2-6 2-7
		// 3-1 3-2 3-3 3-4 3-5 3-6 3-7 
		boolean flag = false;
		String dayValue =null;
		for (int rowNum = 2; rowNum <= 7; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {	
				try {
					dayValue = driver.findElement(By.xpath(before_xpath + rowNum + after_xpath + colNum + "]")).getText();
				}catch (NoSuchElementException e) {
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}
				System.out.println(dayValue);
				if (dayValue.equals(day)) {
					driver.findElement(By.xpath(before_xpath + rowNum + after_xpath + colNum + "]")).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
	}
}
