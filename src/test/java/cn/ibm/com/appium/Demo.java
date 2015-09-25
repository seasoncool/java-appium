package cn.ibm.com.appium;

import java.io.IOException;









public class Demo {
			

	public static void main(String[] args) throws InterruptedException, IOException{
				
		PublicMethod PM = new PublicMethod();
		PM.launchAppiumService();
		Thread.sleep(5000);
		PM.closeService();
		
		
	}
}



