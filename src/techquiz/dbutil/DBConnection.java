
package techquiz.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection 
{
    private static Connection con;
        static
        {
         try
             {
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "techquizapp", "LoginOracle");
            JOptionPane.showMessageDialog(null, "Connected successfully to the DB");
            
             }
        
        catch(Exception ex)
             {
            JOptionPane.showMessageDialog(null, "Cannot connect to the DB");
            ex.printStackTrace();
            System.exit(1);
             }
       }
        public static Connection getConnection()
    {
        return con;
    }
    public static void closeConnection()
    {
        try
        {
        con.close();
         JOptionPane.showMessageDialog(null, "Disconnected successfully from the DB");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Cannot disconnect with the DB");
            ex.printStackTrace();       
            
        }
    }
}
   