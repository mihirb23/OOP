package FypSystem;
import java.util.*;
public class StudentRequestDeregister extends UserRequestAction {
    public StudentRequestDeregister(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        int t;
        System.out.println("----------------------------------------------");
        System.out.println("Request deregister FYP\n");
        System.out.print("Confirm deregister FYP by pressing 1: ");
        t = sc.nextInt();
        RequestAction newAction = new RequestDeregister(this.user.userId);
        RequestRecord newRequestRecord = new RequestRecord(newAction, this.user.userId, this.user.getMyCoordinator());
        if ( t != 1 ) {
            System.out.println();
            return;
        }
        this.request(user, newRequestRecord);
        System.out.println("Request made\n");
    };
}
