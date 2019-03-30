package com.selendriod.demo.driver_setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Test {

	public static void main(String[] args) throws MalformedURLException {
		/**
		 * Below code is used to launch Umniah app on real device 
		 * Installed app via adb install app-debug-with_tutorial.apk 
		 * connect app via wifi using below command
		 * adb tcpip 5555
		 * adb connect #.#.#.# (hidden ip)
		 */
		DesiredCapabilities capabilitiesRealApp = new DesiredCapabilities();
		capabilitiesRealApp.setCapability(MobileCapabilityType.DEVICE_NAME, "#.#.#.#:5555");
		capabilitiesRealApp.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		capabilitiesRealApp.setCapability("appPackage", "com.virtecha.umniah");
		capabilitiesRealApp.setCapability("appActivity", "com.virtecha.umniah.activities.SplashActivity");
		capabilitiesRealApp.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilitiesRealApp.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver driver1 = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesRealApp);
		driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver1.findElement(By.id("com.virtecha.umniah:id/changeLanguge")).click();
		driver1.findElement(By.id("com.virtecha.umniah:id/loginButton")).click();
		driver1.findElement(By.id("com.virtecha.umniah:id/editTextUserName")).sendKeys("TestUser");
		driver1.findElement(By.id("com.virtecha.umniah:id/editTextUserPassword")).sendKeys("TestPassword");
		driver1.findElement(By.id("com.virtecha.umniah:id/buttonLogin")).click();
		
		/**
		 * Below code is used to launch Umniah app on emulator device 
		 * Installed app via adb install app-debug-with_tutorial.apk 
		 * connect app via below command
		 * adb devices
		 */
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		capabilities.setCapability("appPackage", "com.virtecha.umniah");
		capabilities.setCapability("appActivity", "com.virtecha.umniah.activities.SplashActivity");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		AndroidDriver driver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.virtecha.umniah:id/changeLanguge")).click();
		driver.findElement(By.id("com.virtecha.umniah:id/loginButton")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.virtecha.umniah:id/editTextUserName")).sendKeys("TestUser");
		driver.findElement(By.id("com.virtecha.umniah:id/editTextUserPassword")).sendKeys("TestPassword");
		driver.findElement(By.id("com.virtecha.umniah:id/buttonLogin")).click();
	}

}
