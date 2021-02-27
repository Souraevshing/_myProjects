
package techquiz.POJO;

public class UserProfilePOJO 
{
    private static String username;
    private static String userType;

    public static void setUsername(String username) {
        UserProfilePOJO.username = username;
    }

    public static void setUserType(String userType) {
        UserProfilePOJO.userType = userType;
    }

    public static String getUsername() {
        return username;
    }

    public static String getUserType() {
        return userType;
    }
    
}
