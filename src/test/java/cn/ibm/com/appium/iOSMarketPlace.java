package cn.ibm.com.appium;

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;



public class iOSMarketPlace {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		//String URL1 = "http://scwdst2live.bld.dst.ibm.com/marketplace/cloud/us/en-us";
		//String URL2 = "https://wwwstage.ibm.com/marketplace/cloud/us/en-us";
		String URL3 = "http://www.baidu.com";
		String excepted_result = "Search the marketplace";
		IOSDriver dr = iOSInit.launchSimuSafari();	
		dr.get(URL3);
		Thread.sleep(10000);
		dr.swipe(350, 580, 350, 1000, 1500);
		
		
				
		String get_Result_From_Page = dr.findElementById("SimpleSearchForm_SearchTerm").getAttribute("placeholder");		
		if (excepted_result.equals(get_Result_From_Page)){
			System.out.println("Pass");
		}else{
			System.out.println("Failed--the excepted_result is " + excepted_result + " but the actual is  " + get_Result_From_Page);
		}		
		LocateElement.iOSIDSend(dr, "Watson Analytics", "SimpleSearchForm_SearchTerm");
		LocateElement.iOSIDClick(dr, "Layer_1");
		
		dr.quit();
}
}
