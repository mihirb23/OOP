package FypSystem;

public class CoordinatorViewProject  extends UserAction{
    
    public CoordinatorViewProject(User user){
        super(user);
    }
    public void act() {
        System.out.println("----------------------------------------------");
        System.out.println("View all available projects.\n");
        AllProjectListDisplayManager manager = new AllProjectListDisplayManager();
        manager.manage(DataSystem.getAllProjectList());
        System.out.println("Finish display\n");
     };
}