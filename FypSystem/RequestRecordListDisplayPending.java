package FypSystem;
import java.util.*;
public class RequestRecordListDisplayPending extends Display {
    public String userId;
    public RequestRecordListDisplayPending(String userId) {
        this.userId = userId;
    };
    
    /** 
     * @param o
     */
    public void display (Object o) {
        DisplayManager manager = new RequestRecordDisplayManager();
        ArrayList<RequestRecord> requestRecordList = (ArrayList<RequestRecord>) o;
        if ( requestRecordList.size() == 0 ) {
            System.out.println("There is no request.\n");
            return;
        }
        for ( int i = 0; i < requestRecordList.size(); i++ ) {
            if ( requestRecordList.get(i).isStatus(RecordStatus.PENDING) && requestRecordList.get(i).getRecipientId().equals(this.userId)) {
                System.out.print((i)+ "\t|" );
                manager.manage(requestRecordList.get(i));
            }
        }
    }
}
