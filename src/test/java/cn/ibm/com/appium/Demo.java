package cn.ibm.com.appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;









public class Demo {
			

	public static void main(String[] args) throws InterruptedException, IOException{
				
		PublicMethod PM = new PublicMethod();
		for (int i = 0; i < 3; i++){
			PM.launchAppiumService();
			AndroidDriver dr = AndroidInit.launchApp();			
			Thread.sleep(3000);
			dr.quit();						
			PM.closeService();
			}				
	}
}



