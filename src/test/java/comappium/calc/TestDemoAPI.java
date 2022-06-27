package comappium.calc;

import static org.junit.Assert.*;

import java.net.URL;
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

public class TestDemoAPI {
	 static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Start the driver instance
		URL URL = new URL("http://localhost:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability( "appActivity","com.touchboarder.androidapidemos.MainActivity");
        
         driver = new AndroidDriver<MobileElement>(URL, capabilities);
        
        System.out.println(driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    //Handle the initial Navigation till API Demos    
        
     driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
     driver.findElement(By.id("android:id/button1")).click();
     driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
     driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();   
     driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();   
     driver.findElement(By.xpath("//android.widget.TextView[@text='Controls']")).click();   
     driver.findElement(By.xpath("//android.widget.TextView[@text='01. Light Theme']")).click();   
    
     driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit")).sendKeys("Pragati");
     driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit2")).sendKeys("Gupta");
     
     driver.hideKeyboard();
    MobileElement checkbox2 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 2']"));
    boolean chb2Selected = checkbox2.isSelected();

    //check the checkbox
    if(!chb2Selected) {
    	checkbox2.click();
    	
    }
     //Uncheck the checkbox
    if(checkbox2.isSelected()) {
    	checkbox2.click();
    }
	
	
	
	
	driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 1']")).click();
	}
	
	
	

	

	@Test
	

}
