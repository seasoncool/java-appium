package cn.ibm.com.appium;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;



public class Demo {
	
	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException{
		
		PublicMethod PM = new PublicMethod();
		PM.eMailReport("150401848@qq.com", "sss", "sss", "asd");
		
		
	}

}