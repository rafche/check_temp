package watchdog.temp;
import watchdog.temp.temp_check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
		Connection connection = db_conn.getConnection();

		try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from production.visitors");
            while (rs.next()){
                System.out.println(rs.getString("first_name"));
            }

            stmt.close();
            connection.close();
        }
		catch (Exception e){
		    System.out.println(e);
        }
    }
}
