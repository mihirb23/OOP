package FypSystem;
import java.util.*;
public class RequestRecordListDisplayAll extends Display {

    public RequestRecordListDisplayAll() {};
    
    /** 
     * @param o
     */
    public void display(Object o) {
        DisplayManager manager = new RequestRecordDisplayManager();
        ArrayList<RequestRecord> requestRecordList = (ArrayList<RequestRecord>) o;
        if ( requestRecordList.size() == 0 ) {
            System.out.println("There is no request.\n");
            return;
        }
        
        for ( int i = 0; i < requestRecordList.size(); i++ ) {
            System.out.print((i)+ "\t|" );
            manager.manage(requestRecordList.get(i));
        }
        
    }; 
    
}
