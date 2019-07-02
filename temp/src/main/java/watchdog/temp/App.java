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
        temp_check soc_temp = new temp_check();
        System.out.println(soc_temp.get_temp());
    }
}
