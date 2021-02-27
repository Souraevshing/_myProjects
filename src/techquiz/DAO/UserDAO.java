
package techquiz.DAO;

import java.sql.Connection;
import techquiz.POJO.UserPOJO;
import java.sql.SQLException;
import techquiz.dbutil.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO 
{
    public static boolean validateUser(UserPOJO user) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        String query = "select * from users where userid=? and password=? and usertype=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getUserID());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    
    public static boolean addUsers(UserPOJO user) throws SQLException
    {
         Connection conn = DBConnection.getConnection();
         String query = "insert into users values ( ?,?,? )";
         PreparedStatement pst = conn.prepareStatement(query);
         pst.setString(1, user.getUserID());
         pst.setString(2, user.getPassword());
         pst.setString(3, user.getUserType());
         ResultSet rs = pst.executeQuery();
         return rs.next(); 
    }

    public static boolean updatePassword(UserPOJO user) throws SQLException
    {
         Connection conn = DBConnection.getConnection();
         String query = "Update users set password=? where userid=?";
         PreparedStatement pst = conn.prepareStatement(query);
         pst.setString(2, user.getUserID());
         pst.setString(1, user.getPassword());
         int ans=pst.executeUpdate();
         boolean flag=false;
         if(ans==1)
            flag=true;
        return flag;
    }
}
