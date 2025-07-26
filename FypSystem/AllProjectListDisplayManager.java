package FypSystem;
import java.util.*;
//for coordinator 
public class AllProjectListDisplayManager extends DisplayManager {
    
    
    /** 
     * @param o
     */
    public void manage(Object o) {
        Scanner sc = new Scanner(System.in);
        Display display = null;
        int choice;
        ProjectList projectList = (ProjectList) o;
        System.out.println("==============================================");
        System.out.println("View all projects by filter");
        System.out.println("----------------------------------------------");
        System.out.println("1: All projects");
        System.out.println("2: Available projects");
        System.out.println("3: Unavailable projects");
        System.out.println( "4. by supervisor");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        switch(choice) {
            case 1: 
            display = new ProjectListDisplayAll();
            break;
            case 2:
            display = new ProjectListDisplayAvailable();
            break;
            case 3: 
            display = new ProjectListDisplayUnavailable();
            break;
            case 4:
            display = new ProjectListDisplayBySupervisor();
            break;
        }
        display.display(projectList.getProjectList()); 
    }
}
