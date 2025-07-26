package FypSystem;
import java.util.*;
public class FacultyViewMyProjects extends UserAction {
    public FacultyViewMyProjects(User user){
        super(user);
    }
    public void act() {
        Scanner sc = new Scanner(System.in);
        Faculty faculty = (Faculty) user;
        System.out.println("===============================================");
        System.out.println("View my projects.\n");
        MyProjectListDisplayManager manager = new MyProjectListDisplayManager();
        if ( !manager.check(faculty.getMyProject()) ) {
            System.out.println("\nYou don't have any project!\n");
            return;
        }
        manager.manage(faculty.getMyProject());
        System.out.println("\nFinish displaying my projects\n");
     };
}