package FypSystem;

public class UserPasswordManager {
    public UserPasswordManager () {};
    
    /** 
     * @param user
     * @param inputPassword
     * @return boolean
     */
    public boolean verifyPassword (User user, String inputPassword) { 
        return user.verifyPassword(inputPassword);
    };
    
    public void changePassword(User user,String newPassword) {
        user.setPassword(newPassword);
        System.out.println("Change password successfully!\n");
    }
}

