package FypSystem;
import java.util.*;

public class StudentRequestTitleChange extends UserRequestAction {
    public StudentRequestTitleChange(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        int index;
        String title;
        Student student = (Student) user;
        System.out.println("==============================================");
        System.out.println("Request title change.");
        System.out.println("----------------------------------------------");
        System.out.print("Your project: \n");

        MyProjectListDisplayManager manager = new MyProjectListDisplayManager();
        if ( !manager.check(student.getMyProjectList() )){
            System.out.println("You have no project.\n");
            return;
        }
        manager.manage(student.projectList);
        System.out.print("\nEnter project index to change title: ");
        
        if (  student.getMyProjectList().getListSize()==0 ) {
            System.out.println("You are not allocated any project.");
            return;
        }
        
        index = sc.nextInt();
        System.out.println();
        if ( index < 0 ) {
            System.out.println("Invalid project id, exiting...\n");
            return;
        }
        for ( Project tproject: student.getMyProjectList().getProjectList() ) {
            if ( tproject.getProjectId() == index) {
                System.out.print("\nEnter new project title: ");
                title = sc.nextLine();
                title = sc.nextLine();
                Project tProject = DataSystem.getAllProjectList().getProject(index);
                RequestAction newAction = new RequestTitleChange(index, title);
                RequestRecord newRequestRecord = new RequestRecord(newAction, this.user.getUserId(), tProject.getSupervisorId());
                this.request(user, newRequestRecord);
                System.out.println("Request made\n");
                return;
            }
        }
        System.out.println("Invalid Id");
    };
}

                    
            