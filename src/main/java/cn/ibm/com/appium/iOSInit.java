package cn.ibm.com.appium;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class iOSInit {
	
	public static IOSDriver driver;
	public static String URL = "127.0.0.1:4723";
	public static String simuapplocation = "/Users/james/Library/Developer/CoreSimulator/Devices/5BFAC43A-AC38-4691-B71C-B659F61A31F6/data/Containers/Bundle/Application/382F7576-E3AF-4DFB-B27B-CD43D9F1CA79/SalesTracker.app";
	public static String udid = "e51f816ea8511c59bcc631fe89b7049599d2f21a";
	//public static String bundleID = "com.ibm.gbs.mobileAutomation.salestracker";
	public static String bundleID = "com.ibm.cio.be.finance.tools.salesperformance.icm.salestrackerst";	
	
	public static IOSDriver launchSimuSafari() throws IOException, InterruptedException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS"); 
        capabilities.setCapability("deviceName","iPhone 6 Plus");
        capabilities.setCapability("platformVersion", "8.3");
        capabilities.setCapability("browserName", "Safari");
        return driver = new IOSDriver(new URL("http://" + URL +"/wd/hub"), capabilities);         
	}
	
	public static IOSDriver launchSimuApp() throws IOException, InterruptedException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS"); 
        capabilities.setCapability("deviceName","iPad Air");
        capabilities.setCapability("platformVersion", "8.4");
        capabilities.setCapability("app", simuapplocation);
        return driver = new IOSDriver(new URL("http://" + URL +"/wd/hub"), capabilities);         
	}
		
	public static IOSDriver launchRealDevApp() throws IOException, InterruptedException{
		/*
		 * Launch app on real device
		 * 1, source code and cert must available
		 * 2, if app has installed , just use bundleID can launch app
		 * 3, the mobile device have to enable UI Automation from developer
		 * 4, deviceName can not empty , the device name is hard code but can be wrong name
		 * 5, if hybrid page,input ios_webkit_debug_proxy -c e51f816ea8511c59bcc631fe89b7049599d2f21a:27753 -d under command
		 */			
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS"); 
        capabilities.setCapability("deviceName","iOS Device");
        capabilities.setCapability("platformVersion", "8.3");
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("bundleId", bundleID);
        return driver = new IOSDriver(new URL("http://" + URL +"/wd/hub"), capabilities);         
	}
	
	public static IOSDriver launchRealDevWebview() throws IOException, InterruptedException{
	   /*
	    * Launch webview app for web testing
	    * 1, launch app a bit solw around 30s 
	    * 2, MUST lanuch ios_webkit_debug_proxy -c e51f816ea8511c59bcc631fe89b7049599d2f21a:27753
	    * 3, switch to webview mode
	    */
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("platformName","iOS"); 
       capabilities.setCapability("deviceName","iOS Device");
       capabilities.setCapability("platformVersion", "8.3");
       capabilities.setCapability("udid", udid);
       capabilities.setCapability("bundleId", "com.WebViewApp");
       return driver = new IOSDriver(new URL("http://" + URL +"/wd/hub"), capabilities);         
	}
	
}
