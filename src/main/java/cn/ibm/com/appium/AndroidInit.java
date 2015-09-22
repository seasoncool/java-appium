package cn.ibm.com.appium;


import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidInit {
	
	public static AndroidDriver driver;
	public static String URL = "127.0.0.1:4723";
	
	public static AndroidDriver launchApp() throws IOException, InterruptedException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("appPackage", "com.alicall.androidzb");
        capabilities.setCapability("appActivity", "com.alicall.androidzb.Flash");        
        return driver = new AndroidDriver(new URL("http://" + URL +"/wd/hub"), capabilities);         
	}
	
	public static AndroidDriver launchChrome() throws IOException, InterruptedException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("browserName", "Chrome");            
        return driver = new AndroidDriver(new URL("http://" + URL +"/wd/hub"), capabilities);         
	}
	
}
