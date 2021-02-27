
package techquiz.POJO;


public class UserPOJO 
{
    private String userID;
    private String password;
    private String userType;

    public UserPOJO()
    {
        
    }
    public UserPOJO(String userID, String password, String userType) {
        this.userID = userID;
        this.password = password;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
    
}
