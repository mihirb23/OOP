package FypSystem;


public class RequestRecordDisplayDetails extends Display {
    public RequestRecordDisplayDetails() {};
    
    /** 
     * @param o
     */
    public void display (Object o) {
        RequestRecord requestRecord = (RequestRecord) o;
        requestRecord.requestAction.display();
    }
}