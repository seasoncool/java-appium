package cn.ibm.com.appium;

import java.io.IOException;
import io.appium.java_client.android.AndroidDriver;

public class BookTicket {	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		AndroidDriver dr;		
		dr = AndroidInit.launchApp();
		
		LocateElement.byIDClick(dr, "com.mqunar.atom.alexhome:id/atom_alexhome_mod_railway");
		LocateElement.byIDClick(dr, "com.mqunar.atom.train:id/btn_railway_search");
		LocateElement.byIDClick(dr, "com.mqunar.atom.train:id/fl_railway_line_item");
		//Ticket strategy
		int refreshTimes = 3;
		times:
		for (int j = 1; j<=refreshTimes; j++){			
			//Find seat & ticket
			for (int i=1; i <=3; i++){
				String getSeat;
				String getTicket;
				getTicket = LocateElement.byXpathReturn(dr, "//android.widget.LinearLayout["+i+"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
				getSeat = LocateElement.byXpathReturn(dr, "//android.widget.LinearLayout["+i+"]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");			
				//if (getTicket.equals("无票")){System.out.println(getSeat + " has " + getTicket + " left.");}
				if (getTicket.contains("张") && !getSeat.equals("无座")){
					LocateElement.byNameClick(dr, getSeat);
					break times;
					}							
				}
			System.out.println("Going to refresh ticket..");
			dr.swipe(350, 580, 350, 1000, 1500);						
			Thread.sleep(3000);
			if (j == refreshTimes){
				LocateElement.byNameClick(dr, "无座");
			}
		}
		LocateElement.byIDClick(dr, "com.mqunar.atom.train:id/btn_passengers");
		LocateElement.byIDClick(dr, "com.mqunar.atom.train:id/cb");
		LocateElement.byNameClick(dr, "完成");
		Thread.sleep(10000);
		dr.quit();
	}
	}

