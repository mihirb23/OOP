package FypSystem;
import java.util.*;
enum StudentStatus {NOPROJECT, HAVEPROJECT, DEREGISTER};
public class Student extends User
{   
    public ProjectList projectList = new ProjectList()  ;
    protected StudentStatus studentStatus;
    protected int choice;
    

    public ProjectList getMyProjectList() {return this.projectList;}
    public Student (String userId, String name, String password) { 
        super(userId, name, password);
        this.setStatus(StudentStatus.NOPROJECT);
    };
    public void setStatus (StudentStatus t) { this.studentStatus = t;}
    public boolean isStatus(StudentStatus t) {return t.equals(this.studentStatus);}
    
    public void prompt() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("==============================================");
            System.out.println( "STUDENT INTERFACE");
            System.out.println("==============================================");
            System.out.println("Hi " + this.userId );
            System.out.println("----------------------------------------------");
            System.out.println("1: Change Password");
            System.out.println("2: View Available Projects");
            System.out.println("3: View My Project");
            System.out.println("4: View Requests History");
            System.out.println("5: Request");
            System.out.println("-1: logout");
            System.out.println("----------------------------------------------");
            System.out.print("Enter the number of your choice: ");
        
            choice = sc.nextInt();
            System.out.println();
            boolean f = true;
            f = true;
            switch (choice) {
                case 1: 
                    currentAction = new UserChangePassword(this);
                break;
                case 2:
                    if (this.isStatus(StudentStatus.NOPROJECT))
                        currentAction = new UserViewAvailableProject(this);
                    else {
                        System.out.println("You are not able to view available project.");
                        f = false;
                    }
                break;
                case 3:
                    currentAction = new StudentViewMyProject(this);
                    break;
                case 4:
                    currentAction = new UserViewRequestHistory(this);
                    break;
                case 5:
                    currentAction = new StudentRequest(this);
                    break;
                case -1:
                    currentAction = new UserLogout(this);
                break;
            };
            if ( f ) currentAction.act();
        } while (choice != -1 ) ;
                
    }; 
}