package watchdog.temp;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temp_check {

	public static float temp_check() {
		float temprature = 0;
		ProcessBuilder processBuilder = new ProcessBuilder();
    	InputStream stdout = null;
    	String[] cmd = {"/opt/vc/bin/vcgencmd", "measure_temp"};
    	String[] ret;
    	String s = null;
    	
    	try {
			processBuilder.command(cmd);	
			Process process = processBuilder.start();
			stdout = process.getInputStream ();
			BufferedReader out = new BufferedReader (new InputStreamReader (stdout));  
			s = out.readLine();
			temprature = Float.parseFloat(s.replaceAll("[^\\d.]", "" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return temprature;
		
		}

}
