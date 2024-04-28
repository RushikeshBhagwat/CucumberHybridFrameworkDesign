package com.qa.utils;

import java.util.Properties;
import java.io.*;

public class ConfigReader {
 
	private Properties prop;
	
	/**
	 * Below method is used to load the properties from configuration.properties file
	 * @return  it returns properties prop object
	 */
	
	public Properties ini_prop() {
		
		prop=new Properties();
		try {
			FileInputStream fi=new FileInputStream("./src/test/resources/config/configuration.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
}
