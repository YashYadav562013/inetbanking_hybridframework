package com.vandvtechsolution.inetbanking.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
public Properties prop;
	public ConfigDataProvider(String Configdatapath) {
		
		try{
			File fs=new File(Configdatapath);
			FileInputStream	fins=new FileInputStream(fs);
			 prop=new Properties();
			 prop.load(fins);
		}
		catch(Exception e){
			System.out.println("File not found"+e);
		}
		
	}
	public String searchkey(String Key) {
		return prop.getProperty(Key);
	}
	public String getusername () {
		return prop.getProperty("username");
	}
	public String getpassword () {
		return prop.getProperty("password");
	}
	public String getURL () {
		return prop.getProperty("url");
	}
}
