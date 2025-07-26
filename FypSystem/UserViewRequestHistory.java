package FypSystem;

public class UserViewRequestHistory extends UserAction {
    public UserViewRequestHistory(User user){
        super(user);
    }
    public void act() { 
        System.out.println("==============================================");
        System.out.println("View my request history.");
        System.out.println("----------------------------------------------");
        System.out.println("Id\t|Requester\t|Recipient\t|Status\t\t|Detail");
        System.out.println("----------------------------------------------");
        RequestRecordListDisplayManager manager = new RequestRecordListDisplayManager();
        if ( !manager.check(this.user.getMyRequestList())){
            System.out.println("You have no request\n");
            return;
        }
        manager.manage(this.user.getMyRequestList());
        System.out.println("Finish displaying my request history\n");
    };
}
