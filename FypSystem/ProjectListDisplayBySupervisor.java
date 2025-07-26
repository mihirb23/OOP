package FypSystem;
import java.util.*;

public class ProjectListDisplayBySupervisor extends Display {
    public ProjectListDisplayBySupervisor() {};
    
    
    
    /** 
     * @param o
     */
    public void display(Object o) {
        Scanner sc = new Scanner(System.in);
        ProjectDisplayManager projectDisplayManager = new ProjectDisplayManager();
        
        ArrayList<Project> projectList = (ArrayList<Project>) o;
        System.out.print("Enter supervisor ID: ");

        String id;
        id = sc.next();
        if ( DataSystem.allUserList.getUser(id) == null ) {
            System.out.println("User doesn't exist\n");
            return;
        }
        boolean check = false;
        for ( Project project : projectList ) {
            if ( project.isSupervisor(id) ) {
                projectDisplayManager.manage(project);
                check = true;
            }
        }
        if ( !check ) System.out.println("There no project by this supervisor " + DataSystem.getAllUserList().getUser(id).getName() );
    }
}
