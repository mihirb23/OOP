package FypSystem;
import java.util.*;

public class FacultyViewSupervisingProject extends UserAction{
    
    public FacultyViewSupervisingProject(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        Faculty faculty = (Faculty) user;
        System.out.println("----------------------------------------------");
        System.out.println("View my supervising projects.\n");
        MyProjectListDisplayManager manager = new MyProjectListDisplayManager();
        if ( ! manager.check(faculty.getSupervisingProject()) ) {
            System.out.println("No supervising projects.\n");
            return;
        }
        manager.manage(faculty.getSupervisingProject());
        System.out.println("Finish displaying supervising projects\n");
     };
}