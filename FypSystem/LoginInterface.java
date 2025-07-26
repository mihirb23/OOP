package FypSystem;
import java.util.*;

public class LoginInterface implements AppInterface {
    
    public void prompt() {
        System.out.println("==============================================");
        System.out.println("Login Interface");
        System.out.println("----------------------------------------------");
        System.out.print("Enter your UserId: ");
    };
    
    /** 
     * @return User
     */
    public User getUser() {
        Scanner sc = new Scanner(System.in);

        this.prompt();
        String id, password;
        id = sc.next();
        System.out.println();
        User tUser = (User) DataSystem.allUserList.getUser(id);
        if (tUser == null) {
            System.out.println("No such user exist!\n");
            return null;
        }
        System.out.print("Enter your password: ");
        password = sc.next();
        System.out.println();
        UserPasswordManager manager = new UserPasswordManager();
        if ( !manager.verifyPassword(tUser, password) ) {
            System.out.println("Wrong password.\n");
            return null;
        }
        System.out.println("Log in as user " + tUser.userId );
        return tUser;
    }

}