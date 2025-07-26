package FypSystem;

public class RequestRecordListDisplayManager extends DisplayManager {
    public RequestRecordListDisplayManager() {};

    
    /** 
     * @param o
     */
    public void manage(Object o) {
        RequestRecordList requestRecordList = (RequestRecordList) o;
        RequestRecordListDisplayAll display = new RequestRecordListDisplayAll();
        display.display(requestRecordList.requestRecordList);
    }
    public boolean check (Object o) {
        RequestRecordList requestRecordList = (RequestRecordList) o;
        return (requestRecordList.getListSize()!=0);
    }
}
