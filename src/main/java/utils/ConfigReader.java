package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;
	public static Properties getproperties()
	{
		try {
			 prop=new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\Subha\\LiveProjects\\saucedemo\\src\\test\\resources\\config.properties");
			prop.load(f);
		
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
