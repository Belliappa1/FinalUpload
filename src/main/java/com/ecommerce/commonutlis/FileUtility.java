package com.ecommerce.commonutlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author sapnabelliappa
 *
 */
public class FileUtility {
	
	/**
	 *    used to get data from property file based on key
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getKeyValue(String key) throws Throwable  {
		  
			FileInputStream f = new FileInputStream(IConstant.commonDataFilePath);
			 Properties p = new Properties();
			 p.load(f);
			 String value = p.getProperty(key);
		
		return value;
	}

}