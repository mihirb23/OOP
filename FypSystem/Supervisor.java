package FypSystem;
import java.util.*;
public class Supervisor extends Faculty{

    public Supervisor(String userId, String name, String password) {
        super(userId, name, password);
    }
    
    public void prompt() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean check = true;
        do {
            System.out.println("==============================================");
            System.out.println( "FACULTY (SUPERVISOR) INTERFACE");
            System.out.println("==============================================");
            System.out.println("Hi " + this.getName());
            System.out.println("1: Change password");
            System.out.println("2: Create a project");
            System.out.println("3: Update my project");
            System.out.println("4: View my project");
            System.out.println("5. View supervising project");
            System.out.print("6: View pending requests");
            PendingRequestRecordListDisplayManager manager1 = new PendingRequestRecordListDisplayManager(this.getUserId());            
            if ( manager1.havePending(this.requestList) ) System.out.print( " [new]");
            System.out.println("\n7. View request history");
            System.out.println("8. Request to reallocate student");
            System.out.println( "-1: logout");
            System.out.println("----------------------------------------------");
            System.out.print("Enter the number of your choice: ");
            choice = sc.nextInt();
            System.out.println();
            check = true;
            switch (choice) {
                case 1: 
                    currentAction = new UserChangePassword(this);
                break;
                case 2:
                    currentAction = new FacultyCreateProject(this);
                break;
                case 3:
                    currentAction = new FacultyUpdateProject(this);
                break;
                case 4:
                    currentAction = new FacultyViewMyProjects(this);
                break;
                case 5: 
                    currentAction = new FacultyViewSupervisingProject(this);
                break;
                case 6: 
                    currentAction = new FacultyResponseRequest(this);
                break;
                case 7:
                    currentAction = new UserViewRequestHistory(this);
                break;
                case 8:
                    currentAction = new FacultyRequestReallocate(this);
                break;
                case -1:
                    currentAction = new UserLogout(this);
                break;
                default:
                    System.out.println("Invalid input");
                    check = false;
                break;
            }
            if ( check ) currentAction.act();
        } while (choice != -1 ) ;
                
    }; 
    
}
