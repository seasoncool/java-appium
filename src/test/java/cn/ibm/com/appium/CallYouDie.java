package cn.ibm.com.appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;


public class CallYouDie {
		
	public static void main(String[] args) throws IOException, InterruptedException{
		
		String screenlocation = PublicMethod.createFolders("SalesTrack","LaunchDevice");
		AndroidDriver dr = AndroidInit.launchApp();		
		String mobilenumber = "15629176103";		
		String numberbutton = "com.alicall.androidzb:id/num";
		int calltimes = 1;
		PublicMethod.takeScreenShot(dr, screenlocation, "AfterLaunch");
		for (int i = 0; i < calltimes; i++){
			for (int j = 0; j < mobilenumber.length(); j++){
				char getnumber = mobilenumber.charAt(j);
				LocateElement.byIDClick(dr, numberbutton + getnumber);				
			}
			LocateElement.byIDClick(dr, "com.alicall.androidzb:id/dialcall_rl");
			PublicMethod.takeScreenShot(dr, screenlocation, "Going to Call");
			LocateElement.byNameClick(dr, "阿里通直拨");			
			LocateElement.byNameClick(dr, "结束通话");
			PublicMethod.takeScreenShot(dr, screenlocation, "Over");
		}
		dr.quit();
	}
}

