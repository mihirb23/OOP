package FypSystem;

public class UserLogout extends UserAction {
    public UserLogout(User user){
        super(user);
    }
    public void act() {
        System.out.println("==============================================");
        System.out.println("Log out");
        System.out.println("----------------------------------------------\n");
     };
}
