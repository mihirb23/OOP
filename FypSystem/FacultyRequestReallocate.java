package FypSystem;
import java.util.*;

public class FacultyRequestReallocate extends UserRequestAction  {
    public FacultyRequestReallocate(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        
        int projectId;
        String newSupervisorId;
        Faculty faculty = (Faculty) user;

        System.out.println("=================================================");
        System.out.println("Request to reallocate student");
        System.out.println("----------------------------------------------");

        if ( faculty.getSupervisingProject().projectList.size() == 0 ) {
            System.out.println("\nYou are not supervising any project.\n");
            return;
        }

        System.out.println("Your supervising project:");
        MyProjectListDisplayManager manager = new MyProjectListDisplayManager();
        manager.manage(faculty.getSupervisingProject());
        System.out.println("\n----------------------------------------------");
        System.out.print("Enter respective projectId: ");
        projectId = sc.nextInt();
        System.out.println();

        for ( Project tproject:faculty.getSupervisingProject().projectList ) {
            if ( tproject.getProjectId() == projectId) {
                System.out.println("----------------------------------------------");
                System.out.print("Enter replacement supervisor userId: ");
                
                newSupervisorId = sc.next();
                System.out.println();

                User tuser = (User) DataSystem.getAllUserList().getUser(newSupervisorId);
                if ( tuser == null ) {
                    System.out.println("Invalid supervisorId! \n");
                    return;
                }

                RequestAction newAction = new RequestReallocateStudent(DataSystem.getAllProjectList().getProject(projectId), newSupervisorId);
                RequestRecord newRequestRecord = new RequestRecord(newAction, this.user.getUserId(), this.user.getMyCoordinator());
                this.request(user, newRequestRecord);
                System.out.println("Requested!\n");
                return;
            }
        }
        System.out.println("Invalid project Id! \n");
    }
}

                    