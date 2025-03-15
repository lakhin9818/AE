package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	private Properties prop;

	public PropertyReader() {
		try {
			FileInputStream src = new FileInputStream("./src/main/resources/config.properties");
//			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(src);
			src.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause().toString());

		}

	}

	public String getProperty(String ele) {
		String recvd = prop.getProperty(ele);
		System.out.println("data retreived for " + ele + " from property file :" + recvd);
		return recvd;
	}

}