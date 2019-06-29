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
    	InputStream stdout = null;
    	String[] cmd = {"/opt/vc/bin/vcgencmd measure_temp"};
    	String[] ret;
    	String s = null;
    	
    	try {
			Process process = Runtime.getRuntime().exec(cmd);
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
