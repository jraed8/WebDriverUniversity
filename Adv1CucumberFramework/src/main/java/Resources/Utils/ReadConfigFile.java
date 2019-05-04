package Resources.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	protected FileInputStream input = null;
	protected Properties prop = null;
	
	public ReadConfigFile(){
		try {
			input = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		if (prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}
	
}
