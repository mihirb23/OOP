package FypSystem;

public class StudentViewMyProject extends UserAction {
    public StudentViewMyProject(User user){
        super(user);
    }
    public void act() {
        Student student = (Student) user;
        System.out.println("==============================================");
        System.out.println("View my projects.");  
        System.out.println("----------------------------------------------");
        MyProjectListDisplayManager manager = new MyProjectListDisplayManager();
        if ( !manager.check(student.getMyProjectList()) ){
            System.out.println("You have no projects.");
            return;
        }
        manager.manage(student.getMyProjectList());
        System.out.println("Finish displaying my project\n\n");
     };
}

