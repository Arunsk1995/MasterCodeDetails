package org.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Installation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\eclipse-workspace\\" + "selenium2\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
	
	}

}
