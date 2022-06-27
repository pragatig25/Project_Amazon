package com.android;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestAmazon {
	static AndroidDriver<MobileElement> driver;
	@BeforeClass
	public static void RadioGroup() throws MalformedURLException{
		URL URL = new URL("http://localhost:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.amazon.mShop.android.shopping");
    //    capabilities.setCapability( "appActivity","com.amazon.mShop.navigation.MainActivity");
        capabilities.setCapability( "appActivity","com.amazon.mShop.splashscreen.StartupActivity");

        driver = new AndroidDriver<MobileElement>(URL, capabilities);
        System.out.println(driver.getSessionId());
        for(int cnt = 0;cnt<50;cnt++) {
        	try {
        		 Thread.sleep(5000);
        	}catch(InterruptedException e) {
        		e.printStackTrace();
        	}
        }
        
       

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        
	
	}
	
	@Test
	public void test() {
        
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/btn_redirect_marketplace")).click();
		driver.findElement(By.id( "com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view")).click();
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Dell laptop bags");
		driver.findElement(By.xpath("android.widget.TextView[@text='dell laptop bags']")).click();
		
	}		
	
	public void checkAndClick() {
		String txtElement="dell laptop bags";
		List<MobileElement> lstViews = driver.findElements(By.id("android:widget.TextView"));
		boolean flgFound = false;
		while(!flgFound) {
			for(MobileElement view :lstViews) {
				System.out.println(view.getAttribute("text"));
				if(view.getAttribute("text").equals(txtElement)) {
					view.click();
					flgFound=true;
					break;
					
				}
			}
			if(!flgFound) {
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
				
				}


	
				
			

		
	
	}

	
	
