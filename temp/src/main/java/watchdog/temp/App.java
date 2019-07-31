package watchdog.temp;

import java.sql.Connection;
import java.sql.Statement;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

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
        Namespace ns = null;
        ArgumentParser parser = ArgumentParsers
                .newFor("check_temp")
                .build()
                .defaultHelp(true)
                .description("cheicking temprature and storing in DB");
		parser.addArgument("-u", "--user").help("user for DB");
        parser.addArgument("-p", "--password").help("password for DB");

        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }
    	
  		temp_check soc_temp = new temp_check();
		Connection connection = db_conn.getConnection(ns.getString("user"),ns.getString("password"));

		try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("Insert into logger.temp(temp, timestamp) VALUES ("+soc_temp.get_temp() +", NOW())");
            stmt.close();
            connection.close();
        }
		catch (Exception e){
		    System.out.println(e);
        }
    }
}
