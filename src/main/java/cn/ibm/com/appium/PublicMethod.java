package cn.ibm.com.appium;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class PublicMethod {
	
	public static String returnXML(String tagname, int i) {
			File f = new File("DataStream.xml");
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		    DocumentBuilder builder = null;
			try {
				builder = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}   
		    Document doc = null;
			try {
				doc = builder.parse(f);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    //node name should be changed according to xml file, item is index which return first value of xml once found
		    String getXML = doc.getElementsByTagName(tagname).item(i).getFirstChild().getNodeValue();
			return getXML;		   	
			}
	//Reload
	public static String returnXML(String tagname){
		return returnXML(tagname,0);
	}
	
	public static String returnNowTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//time format
		String gettiem = df.format(new Date());// new Date() to get now time
		return gettiem;
	}
	
	public static String createUniqueFolder(String foldername){		
		String curlocation = System.getProperty("user.dir");
        File dir=new File(curlocation + "/" + foldername +"_"+ returnNowTime());
        String folderpath = dir.toString();//convert type from file to string
        if(!dir.exists()){
        	dir.mkdir();//create root folder only 
        	return folderpath;    
	}
		return folderpath;
	}
	
	public static String createFolders(String foldername, String casename){
		String curlocation = System.getProperty("user.dir");
        File dir=new File(curlocation + "/Screenshot/" + foldername + "/" + casename);        
        String folderpath = dir.toString();//convert type from file to string
        if(!dir.exists()){
        	dir.mkdirs();//create sub folder with mkdirs
        	return folderpath;
	}
		return folderpath;
	}
		
	public static void takeScreenShot(AppiumDriver dr,String location,String name){		
        try { 
            File srcFile = ((TakesScreenshot)dr). 
                    getScreenshotAs(OutputType.FILE); 
            FileUtils.copyFile 
            (srcFile,new File("/" + location + name + returnNowTime() + ".png")); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }   
    }  
	
	public void eMailReport(String recipient,String subject,String content,String attchFile) throws MessagingException, UnsupportedEncodingException{
		
		final Properties props = new Properties();

		//smtp host info
		props.put("mail.smtp.host", PublicMethod.returnXML("host"));
		//sender
		props.put("mail.user", PublicMethod.returnXML("username"));
		//password
		props.put("mail.password", PublicMethod.returnXML("password"));
		//from
		props.put("mail.from", PublicMethod.returnXML("from"));
		//to 150401848@qq.com
		props.put("mail.receiver", recipient);
		//cc
		props.put("mail.cc", PublicMethod.returnXML("cc"));
		//bcc
		props.put("mail.bcc", PublicMethod.returnXML("bcc"));
		
	    // authenticator info
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // username and password
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        
        //create email session
        Session mailSession = Session.getInstance(props,authenticator);
        //create message
        MimeMessage message = new MimeMessage(mailSession);
        //open debug info
        //mailSession.setDebug(true);
        //set sender
        InternetAddress from = new InternetAddress(props.getProperty("mail.from"));
        message.setFrom(from);
        //set recipient
        InternetAddress to = new InternetAddress(props.getProperty("mail.receiver"));
        message.setRecipient(RecipientType.TO, to);
        //set CC
        InternetAddress cc = new InternetAddress(props.getProperty("mail.receiver"));
        message.setRecipient(RecipientType.CC,cc);
        //set BCC
        InternetAddress bcc = new InternetAddress(props.getProperty("mail.receiver"));
        message.setRecipient(RecipientType.BCC, bcc);
        //set subject
        message.setSubject(subject);    
        Multipart multipart = new MimeMultipart();
        //set email body
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setContent(content, "text/html;charset=UTF-8");
        multipart.addBodyPart(contentPart);      
        //add attachment need post attachment location as String format
        File attachment = new File(attchFile); 
        if (attachment != null) {
            BodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment);
            attachmentBodyPart.setDataHandler(new DataHandler(source));         
            //MimeUtility.encodeWord
            attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
            multipart.addBodyPart(attachmentBodyPart);
        }
        //add multipart into message
        message.setContent(multipart);
        //send
        Transport.send(message);    
		System.out.println("eMail has send to recipient.");
	    }
}





