package FypSystem;
enum RecordStatus {PENDING, APPROVED, REJECTED};

public class RequestRecord
{
    public String requesterId;
    public String recipientId;
    public RecordStatus recordStatus;
    public RequestAction requestAction;

    public RequestRecord(RequestAction requestAct, String requesterId, String recipientId) {
        this.setRecipientId(recipientId);
        this.setRequesterId(requesterId);
        this.setStatus(RecordStatus.PENDING);
        this.setRequestAct(requestAct);
    }; 

    
    /** 
     * @param tstatus
     * @return boolean
     */
    public boolean isStatus (RecordStatus tstatus) {
        return (tstatus.equals(this.recordStatus));
    }; 

    public void setRecipientId (String recipientId) { this.recipientId = recipientId; };
    public void setRequesterId (String requesterId) { this.requesterId = requesterId; };
    public void setStatus(RecordStatus t) { this.recordStatus = t;}; //for reject/approve request
    public void setRequestAct(RequestAction requestAction) {this.requestAction = requestAction;};
    
    public String getRecipientId() {return this.recipientId;}
    public String getRequesterId() {return this.requesterId;}
    public RecordStatus getStatus() {return this.recordStatus;}
}

























