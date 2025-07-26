package FypSystem;
public class DataSystem {
    
    protected static ProjectList allProjectList = new ProjectList();
    protected static RequestRecordList allRequestList = new RequestRecordList();
    protected static UserList allUserList = new UserList();

    public static ProjectList getAllProjectList() {return DataSystem.allProjectList;}
    public static RequestRecordList getAllRequestList () {return DataSystem.allRequestList;}
    public static UserList getAllUserList() {return DataSystem.allUserList;}
}

