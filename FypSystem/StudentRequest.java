package FypSystem;
import java.util.*;
public class StudentRequest extends UserAction {
    public StudentRequest(User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        int c;
        UserAction currentAction = null;
        System.out.println("==============================================");
        System.out.println("Student Request.");
        System.out.println("==============================================");
        System.out.println("1: Request project allocation");
        System.out.println("2: Request title change");
        System.out.println("3: Request deregister FYP");
        System.out.println("4: exit");
        System.out.println("----------------------------------------------");
        System.out.print("Enter the number of your request type: ");
        c = sc.nextInt();
        System.out.println();
        while ( c > 4 || c < 1 ) {
            System.out.println("Invalid input Enter again");
            c = sc.nextInt();
        }
        switch (c) {
            case 1: 
                currentAction = new StudentRequestProjectAllocation(this.user);
            break;
            case 2:
                currentAction = new StudentRequestTitleChange(this.user);
            break;
            case 3:
                currentAction = new StudentRequestDeregister(this.user);
            break;
            case 4:
                System.out.println("exiting");
                return;
        }
        currentAction.act();
     };
}

                    