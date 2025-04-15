package com.virtualDevice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Task2 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriverLocalService appiumDriverLocalService = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		appiumDriverLocalService.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("deviceName", "ArunAppium");
		options.setCapability("app",
				"C:\\Users\\DELL\\eclipse-workspace\\VirtualDevice\\src\\test\\resources\\ApiDemos-debug.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		WebElement list = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		list.click();
		WebElement custom = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
		custom.click();
		WebElement peopleName = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) peopleName).getId(), "duration", 2000));
		Thread.sleep(3000);
//	 while (!list.isEnabled()) {
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//	}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		WebElement gallery = driver.findElement(AppiumBy.accessibilityId("Gallery"));
		gallery.click();
		WebElement photo = driver.findElement(AppiumBy.accessibilityId("1. Photos"));
		photo.click();
		WebElement swipe = driver.findElement(By.xpath(
				"//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[2]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("mobile:swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) swipe).getId(), "direction", "left", "percent", 0.75));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		WebElement dragAndDrop = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
		dragAndDrop.click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("mobile:dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", 644, "endY", 680));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"));"));
		appiumDriverLocalService.stop();
	}

}
