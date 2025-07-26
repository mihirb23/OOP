package FypSystem;

public class PendingRequestRecordListDisplayManager extends DisplayManager {
    public String userId;

    public PendingRequestRecordListDisplayManager(String userId) {
        this.userId = userId;
    }

    
    /** 
     * @param o
     */
    public void manage(Object o){
        RequestRecordList requestRecordList = (RequestRecordList) o;
        RequestRecordListDisplayPending display = new RequestRecordListDisplayPending(this.userId);
        display.display(requestRecordList.requestRecordList);
    }
    public boolean havePending(Object o){
        RequestRecordList requestRecordList = (RequestRecordList) o;
        for ( RequestRecord trequestRecord: requestRecordList.getRequestList() ) {
            if ( trequestRecord.isStatus(RecordStatus.PENDING) && trequestRecord.getRecipientId().equals(this.userId) ) {
                return true;
            }
        }
        return false;
        /* 
        if ( requestRecordList.getListSize() == 0 ) {
            return false;
        }
        else {
            for ( RequestRecord trequestRecord: requestRecordList.getRequestList() ) {
                if ( trequestRecord.isStatus(RecordStatus.PENDING) &&  trequestRecord.getRecipientId().equals(this.userId)) {
                    return true;
                }
            }
            return false;
        }
        */
    }
}
