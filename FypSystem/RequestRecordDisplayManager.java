package FypSystem;

public class RequestRecordDisplayManager extends DisplayManager {
    public RequestRecordDisplayManager() {};
    
    /** 
     * @param o
     */
    public void manage(Object o) {
        RequestRecordDisplay requestRecordDisplay = new RequestRecordDisplay();
        requestRecordDisplay.display((RequestRecord)o);
    }
}
