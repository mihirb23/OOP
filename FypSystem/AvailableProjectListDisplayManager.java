package FypSystem;

public class AvailableProjectListDisplayManager extends DisplayManager {
    
    /** 
     * @param o
     */
    public void manage(Object o) {
        ProjectList projectList = (ProjectList) o;
        ProjectListDisplayAvailable display = new ProjectListDisplayAvailable();
        display.display(projectList.projectList); 
    }
    public boolean check (Object o) {
        ProjectList projectList = (ProjectList) o;
        return (!(projectList.getListSize()==0));
    }
}
