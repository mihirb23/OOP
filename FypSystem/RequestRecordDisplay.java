package FypSystem;

public class RequestRecordDisplay extends Display {
    public RequestRecordDisplay() {};
    
    /** 
     * @param o
     */
    public void display (Object o) {
        RequestRecord requestRecord = (RequestRecord) o;
        System.out.print(requestRecord.requesterId + "\t\t|" 
        + requestRecord.recipientId + "\t\t|"
        + requestRecord.recordStatus + "\t|");
        requestRecord.requestAction.display();
    }
}