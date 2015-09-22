package cn.ibm.com.appium;

import java.util.Set;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LocateElement {
	
	static int timeout = 30;
	
	public static void byIDSend(AndroidDriver dr, String content, String target){		
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.id(target)));
		WebElement element = dr.findElement(By.id(target));	
		//highLightElement(dr, element);
		element.clear();
		element.sendKeys(content);
	}
	
	public static void byNameSend(AndroidDriver dr, String content, String target){
		System.out.println("Going To Send: " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
		WebElement element = dr.findElement(By.name(target));
		element.clear();
		element.sendKeys(content);		
	}
	
	public static void byIDClick(AndroidDriver dr,String target){
		System.out.println("Going To Click: " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.id(target)));
		WebElement element = dr.findElement(By.id(target));
		element.click();		
	}
	
	public static void byNameClick(AndroidDriver dr,String target){
		System.out.println("Going To Click: " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
		WebElement element = dr.findElement(By.name(target));
		element.click();		
	}
	
	public static void byXpathClick(AndroidDriver dr,String target){
		System.out.println("Going To Click:" + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
		WebElement element = dr.findElement(By.xpath(target));
		element.click();	
	}

	public static void byXpathSend(AndroidDriver dr, String content, String target){
		System.out.println("Going To Send:" + content + " In To " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
		WebElement element = dr.findElement(By.xpath(target));
		element.clear();
		element.sendKeys(content);
	}
	
	public static String byXpathReturn(AndroidDriver dr, String target){		
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
		WebElement element = dr.findElement(By.xpath(target));
		return element.getText();	
	}
	
	public static String byIDReturn(AndroidDriver dr, String target){		
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.id(target)));
		WebElement element = dr.findElement(By.id(target));
		return element.getText();	
	}
	
	public static String byNameReturn(AndroidDriver dr, String target){		
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
		WebElement element = dr.findElement(By.name(target));
		return element.getText();	
	}
	
	public static void iOSIDSend(IOSDriver dr, String content, String target){		
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.id(target)));
		WebElement element = dr.findElement(By.id(target));	
		//highLightElement(dr, element);
		element.clear();
		element.sendKeys(content);
	}
	
	public static void iOSIDClick(IOSDriver dr,String target){
		System.out.println("Going To Click: " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.id(target)));
		WebElement element = dr.findElement(By.id(target));
		element.click();
	}
		
	public static void iOSNameClick(IOSDriver dr,String target){
		System.out.println("Going To Click:" + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
		MobileElement element = (MobileElement) dr.findElement(By.name(target));		
		element.click();
	}
		
	public static void iOSClassNameClick(IOSDriver dr,String target){
		System.out.println("Going To Click:" + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.className(target)));
		MobileElement element = (MobileElement) dr.findElement(By.className(target));		
		element.click();
	}
	
	public static void iOSXpathClick(IOSDriver dr,String target){
		System.out.println("Going To Click:" + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
		MobileElement element = (MobileElement) dr.findElement(By.xpath(target));		
		element.click();
	}
		
	public static String iOSXpathReturn(IOSDriver dr, String target){		
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
		MobileElement element = (MobileElement) dr.findElement(By.xpath(target));
		return element.getText();	
	}
	
	public static void iOSXpathSend(IOSDriver dr, String content, String target){
		System.out.println("Going To Send:" + content + " In To " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
		MobileElement element = (MobileElement) dr.findElement(By.xpath(target));
		element.clear();
		element.sendKeys(content);
	}
	
	public static void iOSNameSend(IOSDriver dr, String content, String target){
		System.out.println("Going To Send:" + content + " In To " + target);
		new WebDriverWait(dr,timeout).until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
		MobileElement element = (MobileElement) dr.findElement(By.name(target));
		element.clear();
		element.sendKeys(content);		
	}
	
	public static void webViewMode(AppiumDriver dr){
		Set<String> contextNames = dr.getContextHandles();
		for (String contextName : contextNames) {
			//System.out.println(contextNames);
			if (contextName.contains("WEBVIEW")) {
				dr.context(contextName);
				break;
	}
	}
	}
	
	public static void rotateScreen(AppiumDriver dr){
		//LANDSCAPE or PORTRAIT
		((AppiumDriver) dr).rotate(ScreenOrientation.LANDSCAPE);
	} 
	
	public static void nativeMode(AppiumDriver dr){
		dr.context("NATIVE_APP");
	}
		
    public static void swipeToUp(AppiumDriver dr, int during) {
        int width = dr.manage().window().getSize().width;
        int height = dr.manage().window().getSize().height;
        dr.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
    }
    
    public static void swipeToDown(AppiumDriver dr, int during) {
        int width = dr.manage().window().getSize().width;
        int height = dr.manage().window().getSize().height;
        dr.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
    }

    public void swipeToLeft(AppiumDriver dr, int during) {
        int width = dr.manage().window().getSize().width;
        int height = dr.manage().window().getSize().height;
        dr.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
    }
    
    public void swipeToRight(AppiumDriver dr, int during) {
        int width = dr.manage().window().getSize().width;
        int height = dr.manage().window().getSize().height;
        dr.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
    }
    
	public static void highLightElement(WebDriver dr,WebElement element){
		//this function only works for hybrid page which means unable to high light for native elements
		JavascriptExecutor js = (JavascriptExecutor) dr;
		 js.executeScript("element = arguments[0];" +
	             "original_style = element.getAttribute('style');" +
	                 "element.setAttribute('style', original_style + \";" +
	             "border: 2px solid red;\");" +
	             "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
	}


}
