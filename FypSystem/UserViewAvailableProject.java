package FypSystem;

public class UserViewAvailableProject extends UserAction {
    public UserViewAvailableProject(User user){
        super(user);
    }
    public void act() {
        System.out.println("\n==============================================");
        System.out.println("View available projects.");
        System.out.println("----------------------------------------------\n");
        AvailableProjectListDisplayManager manager = new AvailableProjectListDisplayManager();
        if ( !manager.check(DataSystem.getAllProjectList())){
            System.out.println("No available projects.\n");
            return;
        }
        manager.manage(DataSystem.getAllProjectList());
        System.out.println("\nFinish display\n");
     };
}
