package FypSystem;
import java.util.*;

public class FacultyResponseRequest extends UserAction {
    public FacultyResponseRequest (User user){
        super(user);
    }
    
    public void act() {
        Scanner sc = new Scanner(System.in);
        int choice, requestIndex;
        System.out.println("===============================================");
        System.out.println("View Pending Request.");
        System.out.println("----------------------------------------------");
        System.out.println("\nId\t|Requester\t|Recipient\t|Status\t|Detail");
        System.out.println("----------------------------------------------");

        PendingRequestRecordListDisplayManager manager = new PendingRequestRecordListDisplayManager(this.user.getUserId());
        if ( !manager.havePending(this.user.getMyRequestList())) {
            System.out.println("No pending request received! \n");
            return;
        }

        manager.manage(this.user.getMyRequestList());
        System.out.println("----------------------------------------------");
        System.out.print("Input request Id to approve or reject: ");
        requestIndex = sc.nextInt();

        if ( this.user.getMyRequestList().getListSize() <= requestIndex || requestIndex < 0 ) {
            System.out.println("Invalid request id.\n");
            return;
        }

        RequestRecordDisplayDetailsManager manager1 = new RequestRecordDisplayDetailsManager();
        RequestRecord requestRecord = this.user.getMyRequestList().getRequestRecord(requestIndex);
        System.out.println("\nRequest details: ");
        manager1.manage(requestRecord);
        System.out.println();
        System.out.println("===============================================");
                System.out.println("Response to this request");
        System.out.println("1: Approve");
        System.out.println("2: Reject");
        System.out.println("3: Exit");
        System.out.println("----------------------------------------------");

        System.out.print("Enter the number of your choice: ");
        choice = sc.nextInt();
        System.out.println();

        while ( choice > 3 || choice < 1 ) {
            System.out.println("Invalid input. Re-enter choice: ");
            choice = sc.nextInt();
        }
        boolean check = true;
        switch (choice) {
            case 1: 
                check = requestRecord.requestAction.approve();
            break;
            case 2: 
                check = requestRecord.requestAction.reject();
            break;
            case 3:
                System.out.println("Exit \n");
                return;
        }
        if ( check ) {
            requestRecord.setStatus(RecordStatus.APPROVED);
            System.out.println("Approve request\n");
        }
        else {
            requestRecord.setStatus(RecordStatus.REJECTED);
            System.out.println("Reject request\n");
        }
    }
}