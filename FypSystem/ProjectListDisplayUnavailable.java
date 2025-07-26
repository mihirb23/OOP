
package FypSystem;
import java.util.ArrayList;

public class ProjectListDisplayUnavailable extends Display {

    
    /** 
     * @param o
     */
    public void display(Object o) {
        ProjectDisplayManager projectDisplayManager = new ProjectDisplayManager();
        ArrayList<Project> projectList = (ArrayList<Project>) o;
        if ( projectList.size() == 0 ) {
            System.out.println("There is no unavailable projects.\n");
            return;
        }
        else {
            for ( Project project : projectList ) {
                if ( !project.isStatus(ProjectStatus.AVAILABLE) ){
                    projectDisplayManager.manage(project);
                }
            }
        }
    };
}
