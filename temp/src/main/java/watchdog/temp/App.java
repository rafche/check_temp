package watchdog.temp;

import java.sql.Connection;
import java.sql.Statement;

/**
 * checking the temperature of SOC 
 * getting SOC Temprature
 * establish a DB connection
 * write values to DB
 */
public class App 
{

    public static void main(String[] args )
    {
  		temp_check soc_temp = new temp_check();
		Connection connection = db_conn.getConnection();

		try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into production.visitors (temp, timestamp) VALUES ("+soc_temp.get_temp() +", sysdate)");
            stmt.close();
            connection.close();
        }
		catch (Exception e){
		    System.out.println(e);
        }
    }
}
