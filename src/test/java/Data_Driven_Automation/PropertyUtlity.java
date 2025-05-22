package Data_Driven_Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtlity {
	
	public static FileInputStream fi;
	public static Properties prop;
	
	public static String getXpath(String Key) throws IOException {
		
		String path = System.getProperty("user.dir") + "\\TestData\\Xpaths_Properties.properties";
		prop = new Properties();
		fi = new FileInputStream(path);
		
		prop.load(fi);
		String value = prop.getProperty(Key);
		
		fi.close();
		return value;
	}
	
}
