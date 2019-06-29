package watchdog.temp;
import java.io.*;
import java.util.*;


/**
 * checking the temprature of SOC 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
			while ((s = out.readLine()) != null) { 
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
