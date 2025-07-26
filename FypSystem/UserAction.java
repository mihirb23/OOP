package FypSystem;
public abstract class UserAction {
    protected User user;
    public UserAction(User user){
        this.user = user;
    }
    public abstract void act (); 
}
