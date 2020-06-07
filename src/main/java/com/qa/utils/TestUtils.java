package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.qa.BaseTest;

import javax.xml.parsers.DocumentBuilderFactory;

public class TestUtils {
	
	static TestUtils utils = new TestUtils();
	public static final long WAIT = 60;
	
	public static HashMap<String, String> parseStringXML(InputStream file) throws Exception{
		
		HashMap<String, String> stringMap = new HashMap<String, String>();
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		 
		//Build Document
		Document document = builder.parse(new FileInputStream("/Users/sharadgupta/Documents/automation/TDDFramework/src/test/resources/strings/strings.xml"));
		//Document document = builder.parse(new FileInputStream("System.getProperty(\"user.dir\") + \"src/test/resources/strings/strings.xml\""));
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();
		 
		//Get all elements
		NodeList nList = document.getElementsByTagName("string");
		 
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    Element eElement = (Element) node;
		    // Store each element key value in map
		    stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
		 }
		}
		return stringMap;
	}

	public static String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		utils.log().info(dateFormat.format(date));
		return dateFormat.format(date);
	}
	
	public void log(String txt) {
		BaseTest base = new BaseTest();
		String msg = Thread.currentThread().getId() + ":" + ":" + base.getDeviceName() + ":"
				+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;
		
		System.out.println(msg);
		
		String strFile = "logs" + File.separator + "_" + base.getDeviceName() 
				+ File.separator + base.getDateTime();

		File logFile = new File(strFile);

		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(logFile + File.separator + "log.txt",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println(msg);
	    printWriter.close();
	}
	
	public static Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	
	
}
