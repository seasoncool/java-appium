package cn.ibm.com.appium;


import io.appium.java_client.ios.IOSDriver;
import java.io.IOException;


public class SalesTracker {
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		

		IOSDriver dr = iOSInit.launchSimuApp();
		//LocateElement.rotateScreen(dr);
		LocateElement.webViewMode(dr);
		Thread.sleep(5000);
		LocateElement.iOSIDSend(dr, "zxyzhan@cn.ibm.com","username");
		LocateElement.iOSIDSend(dr, "Simpson1!","password");
		LocateElement.iOSIDClick(dr, "loginBtn");
		LocateElement.nativeMode(dr);
		LocateElement.iOSNameClick(dr, "OK");
		LocateElement.webViewMode(dr);
		LocateElement.iOSIDSend(dr, "andreas.walter@de.ibm.com", "sellerEmailId");
		LocateElement.iOSIDClick(dr, "prodBt");
		
		Thread.sleep(10000);
		LocateElement.iOSClassNameClick(dr, "menu");
		
//		Thread.sleep(5000);
//		dr.swipe(508, 322, 508, 637, 1000);
//		Thread.sleep(2000);
//		dr.swipe(508, 322, 508, 637, 1000);
//		Thread.sleep(2000);
//		dr.swipe(508, 322, 508, 637, 1000);
//		Thread.sleep(2000);
		//dr.swipe(368, 488, 368, 961, 1000);

		
		
		
//		LocateElement.iOSIDClick(dr, "loginBtn");
//		LocateElement.nativeMode(dr);
//		LocateElement.iOSNameClick(dr, "OK");
//		LocateElement.webViewMode(dr);
//		LocateElement.iOSIDClick(dr, "nav-opportunities");
//		//LocateElement.iOSClassNameClick(dr,"menu");
//		Thread.sleep(10000);
//		dr.quit();
	}
	}

