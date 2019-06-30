package watchdog.temp;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temp_check {

	public static int temp_check() {
		int temprature = -10;
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
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(s);
			temprature = Integer.parseInt(m.group(0));
			System.out.println(temprature);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return temprature;
		
		}

}