package com.virtualDevice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Task3 {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriverLocalService appiumDriverLocalService = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		appiumDriverLocalService.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("deviceName", "ArunAppium");
		options.setCapability("app",
				"C:\\Users\\DELL\\eclipse-workspace\\VirtualDevice\\src\\test\\resources\\General-Store.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		Thread.sleep(5000);
		WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
		country.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"India\"))"));
		WebElement dropdown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]"));
		dropdown.click();
		WebElement letShop = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShop.click();
		@Nullable
		String attribute = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		System.out.println(attribute);
		
		WebElement name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		name.sendKeys("Arun");
		letShop.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))"));
		WebElement addKart = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[3]"));
		addKart.click();
		WebElement addToKart = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
	    addToKart.click();
	    WebElement checkbox = driver.findElement(By.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]"));
	    checkbox.click();
	    WebElement purchaseButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
	    purchaseButton.click();
		appiumDriverLocalService.stop();
		
	}

}
