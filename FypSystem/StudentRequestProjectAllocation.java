package FypSystem;
import java.util.*;
public class StudentRequestProjectAllocation extends UserRequestAction {
    public StudentRequestProjectAllocation(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        int index, t;
        Student student = (Student) user;
        if ( student.getMyProjectList().getListSize() != 0 ) {
            System.out.println("Allocated with a project already. \n");
            return;
        }
        System.out.println("==============================================");
        System.out.println("Request project allocation.");
        System.out.println("----------------------------------------------");
        System.out.print("Enter project index: ");
        index = sc.nextInt();
        System.out.println();
        if ( index > DataSystem.allProjectList.projectList.size() || index < 0 ) {
            System.out.println("Invalid project id.");
            return;
        }
        if ( ! DataSystem.allProjectList.projectList.get(index).isStatus(ProjectStatus.AVAILABLE) ) {
            System.out.println("Project selected is not available.\n");
            return;
        }
        Project project = DataSystem.getAllProjectList().getProject(index);
        System.out.print("Project choice is:\n");
        ProjectDisplayManager manager = new ProjectDisplayManager();
        manager.manage(project);
        System.out.print("\nConfirm your project choice with project " + index + " by pressing 1: ");
        t = sc.nextInt();
        System.out.println();
        if ( t == 1 ) {
            RequestAction newAction = new RequestAllocation(project, this.user.getUserId());
            RequestRecord newRequestRecord = new RequestRecord(newAction, this.user.getUserId(), this.user.getMyCoordinator());
            this.request(user, newRequestRecord);
            System.out.println("Request made.\n");
        }
        else {
            System.out.println("Confimation fail.");
        }
     };
}

