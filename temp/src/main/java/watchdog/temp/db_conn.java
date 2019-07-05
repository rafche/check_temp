package watchdog.temp;
import java.sql.*;


public class db_conn {
    static Connection con=null;
    public static Connection getConnection()
    {
        if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection("logger", "root");
    }

    private static Connection getConnection(String db_name,String user_name)
    {
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://10.0.0.2/"+db_name+"?user="+user_name);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }

}
