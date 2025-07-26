package FypSystem;
import java.util.*;

public class FacultyCreateProject extends UserAction {
    
    public FacultyCreateProject (User user){
        super(user);
    }
    public void act() {
        Scanner sc = new Scanner(System.in);
        String title;
        System.out.println("=================================================");
        System.out.println("Create a project");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter project title: ");
        Faculty faculty = (Faculty) user;
        title = sc.next();
        System.out.println();

        Project project = new Project(title, this.user.getUserId(), DataSystem.getAllProjectList().projectList.size());
        
        faculty.getMyProject().projectList.add(project);
        DataSystem.getAllProjectList().projectList.add(project);

        System.out.println("Project is created.\n");
    }
}