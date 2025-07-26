package FypSystem;
public class CoordinatorViewAllProject  extends UserAction{
    
    public CoordinatorViewAllProject(User user){
        super(user);
    }
    public void act() {
        System.out.println("=================================================");
        System.out.println("View all available projects with filter.\n");
        System.out.println("----------------------------------------------\n");
        AllProjectListDisplayManager manager = new AllProjectListDisplayManager();
        manager.manage(DataSystem.getAllProjectList());
        System.out.println("Finish display\n");
     };
}