package FypSystem;
import java.util.*;

public class UserList {
    public ArrayList<User> userList = new ArrayList<User>();
    
    public UserList () {}

    public void addUser (User tuser) { userList.add(tuser);}
    
    /** 
     * @param id
     * @return User
     */
    public User getUser(String id) {
        for ( User user : userList ) {
            if ( user.getUserId().equals(id) ) return user;
        }
        return null;
    }
    public String getIdWithName(String name) {
        for ( User user : userList ) {
            if ( user.getName().equals(name) ) {
                return user.getUserId();
            }
        }
        return "";
    }
    public void remove(User user) { this.userList.remove(user); }; 

}

