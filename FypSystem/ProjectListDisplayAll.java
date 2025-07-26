package FypSystem;
import java.util.ArrayList;

public class ProjectListDisplayAll extends Display {

    
    /** 
     * @param o
     */
    public void display(Object o) {
        DisplayManager manager = new ProjectDisplayManager();
        ArrayList<Project> projectList = (ArrayList<Project>) o;
        if ( projectList.size() == 0 ) {
            System.out.println("arThere is no projects.\n");
            return;
        }
        for ( Project project : projectList ){
            manager.manage(project);
        }
    }; 
    
}
