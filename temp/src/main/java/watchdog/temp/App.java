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
        float soc_temp = temp_check.temp_check();
        System.out.println(soc_temp);
    }
}
