package FypSystem;
import java.util.*;

public class RequestRecordList{
    ArrayList<RequestRecord> requestRecordList = new ArrayList<RequestRecord>();
    public ArrayList<RequestRecord>  getRequestList() {return this.requestRecordList;}
    public void addRequestRecord (RequestRecord requestRecord) { this.requestRecordList.add(requestRecord);}
    public RequestRecord getRequestRecord(int index) { return this.requestRecordList.get(index);}
    public int getListSize() {return this.requestRecordList.size();}
}

