package util.common;


import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import javax.enterprise.context.Dependent;


@Dependent
public class PropertiesUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String getValue(String filename, String key) {
		String result = null;
		try {
			String propFileName = filename;
			InputStream is = getClass().getClassLoader().getResourceAsStream(propFileName);
			Properties prop = new Properties();
			prop.load(is);
			result = prop.getProperty(key);
			is.close();
		}
		catch (Exception ex) {
			System.out.println("property file '" + filename + "' not found in the classpath");
		}
		return result;
    }
	
	
	
	
	
	
}
