package FypSystem;

public abstract class User {
    protected String userId;
    protected String name;
    private String password;
    private String myCoordinator;
    protected RequestRecordList requestList;
    UserAction currentAction = null;
    public User(String userId, String name, String password) {
        this.userId = (userId);
        this.name = (name);
        this.setPassword(password);
        this.myCoordinator = "ASFLI";
        this.requestList  = new RequestRecordList() ;
    }
    

    protected void setPassword(String password) { this.password = password; }

    public String getUserId(){return this.userId;}
    public String getName(){return this.name;}
    public String getMyCoordinator() {return this.myCoordinator;}
    public RequestRecordList getMyRequestList() {return this.requestList;}
    
    /** 
     * @param password
     * @return boolean
     */
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
    public abstract void prompt();
    
}