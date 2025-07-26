package FypSystem;
//no use maybe
public class ProjectListDisplayManager extends DisplayManager {
    

    
    /** 
     * @param o
     */
    public void manage(Object o) {
        Display display = null;
        ProjectList projectList = (ProjectList) o;
        display.display(projectList.projectList); 
    }
    
}