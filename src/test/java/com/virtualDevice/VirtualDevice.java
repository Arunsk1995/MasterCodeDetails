package com.virtualDevice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class VirtualDevice {
	public static void main(String[] args) throws MalformedURLException {

		AppiumDriverLocalService appiumDriverLocalService = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		appiumDriverLocalService.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("deviceName", "ArunAppium");
		options.setCapability("app",
				"C:\\Users\\DELL\\eclipse-workspace\\VirtualDevice\\src\\test\\resources\\ApiDemos-debug.apk");
		options.setCapability("appPackage", " io.appium.android.apis");
		options.setCapability("appActivity", "io.appium.android.apis.view.AutoComplete1");
		

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		
//		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
//		views.click();
//		
//		WebElement autoComplete = driver.findElement(AppiumBy.accessibilityId("Auto Complete"));
//		autoComplete.click();
//		
//		WebElement screenTop = driver.findElement(AppiumBy.accessibilityId("1. Screen Top"));
//		screenTop.click();
		
		WebElement textBox = driver.findElement(By.id("io.appium.android.apis:id/edit"));
//		textBox.sendKeys("Application");
		driver.setClipboardText("Application");
		textBox.sendKeys(driver.getClipboardText());
		
		WebElement focus = driver.findElement(AppiumBy.accessibilityId("Give me Focus"));
		focus.click();
		
//		DeviceRotation rotation = new DeviceRotation(0, 0, 90);
//		driver.rotate(rotation);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		appiumDriverLocalService.stop();
	}
}
