package watchdog.temp;
import watchdog.temp.temp_check;

/**
 * checking the temperature of SOC 
 *
 */
public class App 
{

    public static void main(String[] args )
    {
    	for(int i = 0; i < 50; i++) {
			temp_check soc_temp = new temp_check();
			System.out.println(soc_temp.get_temp());
    	}
    }
}
