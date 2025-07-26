package FypSystem;
import java.util.*;

public class FacultyUpdateProject extends UserAction {
    public FacultyUpdateProject (User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        Faculty faculty = (Faculty) user;
        int index;
        String title;
        System.out.println("===============================================");
        System.out.println("Update my project.");
        System.out.println("----------------------------------------------");
        System.out.println("View my projects.\n");
        MyProjectListDisplayManager manager = new MyProjectListDisplayManager();
        if ( !manager.check(faculty.getMyProject())){
            System.out.println("No project");
            return;
        }
        manager.manage(faculty.getMyProject());

        System.out.print("\nEnter project id to update: ");
        index = sc.nextInt();
        System.out.println();
        for (Project tproject: faculty.getMyProject().getProjectList() ){
            if (tproject.getProjectId()==index ) {
                Project project = DataSystem.getAllProjectList().getProject(index);
                System.out.print("Enter new title of project: ");
                title = sc.next();
                project.setTitle(title);
                System.out.println("Project is updated successfully.\n");
                return;
            }
        }
        System.out.println("Invalid project id!\n");
    }
}

