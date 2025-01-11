package com.crm.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReaddFromProperty 
{
	public static String propertyData(String key) throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configure.properties");
		
		prop.load(fis);
		
		String data = prop.getProperty(key);
		
		return data;
	}
}