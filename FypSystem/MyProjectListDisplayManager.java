package FypSystem;
//for student's myproject list, faculty's superising project and myproject 
public class MyProjectListDisplayManager extends DisplayManager {

    
    /** 
     * @param o
     */
    public void manage(Object o) {
        ProjectList projectList = (ProjectList) o;
        ProjectListDisplayAll projectListDisplayAll = new ProjectListDisplayAll();
        projectListDisplayAll.display(projectList.projectList);
    }
    public boolean check (Object o){
        ProjectList projectList = (ProjectList) o;
        return ((projectList.getListSize()!=0));
    }
}
