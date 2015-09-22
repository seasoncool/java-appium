package cn.ibm.testng;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import cn.ibm.com.appium.AndroidInit;
import cn.ibm.com.appium.LocateElement;



public class Template {
	
	private AndroidDriver dr;
	
	@BeforeTest
	public void testBefore () throws IOException, InterruptedException{
		dr = AndroidInit.launchApp();
		LocateElement.byNameClick(dr, "稍后再说");
	}
	
	@AfterTest
	public void cleanEnv() throws InterruptedException, UnsupportedEncodingException, MessagingException{

		Thread.sleep(5000);
		dr.quit();		
	}
	
	@Test
	public void launchDevice(){	
		LocateElement.byIDClick(dr, "com.alicall.androidzb:id/num1");
		LocateElement.byIDClick(dr, "com.alicall.androidzb:id/num2");
		LocateElement.byIDClick(dr, "com.alicall.androidzb:id/num3");
	}
	

}
