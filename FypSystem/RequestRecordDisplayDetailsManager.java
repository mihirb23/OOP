package FypSystem;

public class RequestRecordDisplayDetailsManager extends DisplayManager {
    public RequestRecordDisplayDetailsManager() {};
    
    /** 
     * @param o
     */
    public void manage(Object o) {
        RequestRecordDisplayDetails requestRecordDisplay = new RequestRecordDisplayDetails();
        requestRecordDisplay.display((RequestRecord)o);
    }
}
