package FypSystem;
import java.util.ArrayList;

public class ProjectListDisplayAvailable extends Display {

    public ProjectListDisplayAvailable() {};
    
    /** 
     * @param o
     */
    public  void display(Object o) {
        ProjectDisplayManager projectDisplayManager = new ProjectDisplayManager();
        ArrayList<Project> projectList = new ArrayList<Project> ();
        projectList = (ArrayList<Project>) o;
        if ( projectList.size() == 0 ){
            System.out.println("There is no available projects.\n");
            return;
        }
        for ( Project project : projectList ) {
            if ( project.isStatus(ProjectStatus.AVAILABLE) )
                projectDisplayManager.manage(project);
        }
    };
}
