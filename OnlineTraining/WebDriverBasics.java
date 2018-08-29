package OnlineTraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/elmurotyangiboev/Documents/Selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.google.com/"); // enter url

		String title = driver.getTitle(); // get title

		System.out.println(title);

		// validation point
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("in-correct title");
		}

		System.out.println(driver.getCurrentUrl());

//		System.out.println(driver.getPageSource());

		driver.quit(); // quit the browser

	}

}
