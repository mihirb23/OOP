package FypSystem;
import java.util.*;
public class UserChangePassword extends UserAction {
    public UserChangePassword(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        String currentPassword, newPassword;
        System.out.println("==============================================");
        System.out.println("Change Password.");
        System.out.println("----------------------------------------------");
        System.out.print("Enter current password: ");
        
        currentPassword = sc.next();
        System.out.println();

        UserPasswordManager manager = new UserPasswordManager();

        if ( !manager.verifyPassword(this.user, currentPassword)  ){
            System.out.println("Wrong current password.\n");
            return;
        }
        System.out.print("Enter new password: ");
        newPassword = sc.next();
        System.out.println();
        while ( newPassword.equals(currentPassword) ){
            System.out.print("Same password. Enter different password: ");
            newPassword = sc.next();
            System.out.println();
        }
        manager.changePassword(this.user, newPassword);
    }
}


                    