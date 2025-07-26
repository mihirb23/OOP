package FypSystem;

public class UserInterface implements AppInterface {
    
    public UserInterface () {};
    public void prompt() {
        System.out.println();
    }
    
    /** 
     * @param user
     */
    public void promptUser(User user) {
        prompt();
        user.prompt();
    }
}


