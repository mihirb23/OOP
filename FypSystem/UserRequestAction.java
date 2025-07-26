
package FypSystem;

public abstract class UserRequestAction extends UserAction {
    public UserRequestAction(User user) {
        super(user);
    }
    public abstract void act (); 
    
    /** 
     * @param user
     * @param requestRecord
     */
    public void request (User user, RequestRecord requestRecord) {
        user.getMyRequestList().addRequestRecord(requestRecord);
        DataSystem.getAllRequestList().addRequestRecord(requestRecord);

        User recipient = DataSystem.getAllUserList().getUser(requestRecord.getRecipientId());
        recipient.getMyRequestList().addRequestRecord(requestRecord);
    }
}
