package FypSystem;
enum ProjectStatus {AVAILABLE, UNAVAILABLE, ALLOCATED};
public class Project
{
    public int projectId;
    private String title;
    private String supervisorId; 
    private String supervisorName;
    private String studentId;
    private String studentName;
    private ProjectStatus projectStatus;

    public Project(String title, String supervisorId, int id) {
        this.setTitle(title);
        this.setSupervisorId(supervisorId);
        this.setProjectId(id);
        this.setStatus(ProjectStatus.AVAILABLE);
        this.supervisorName = DataSystem.getAllUserList().getUser(supervisorId).getName();

    };
    public void setProjectId (int id) {this.projectId = id;}
    public void setTitle (String title) {this.title = title;}
    public void setSupervisorId(String newId) {this.supervisorId = newId;}
    public void setStatus(ProjectStatus t) {this.projectStatus = t;};
    public void setStudentId(String studentId) { this.studentId = studentId;}; 
    public String getSupervisorName() {return this.studentName;}
    public String getStudentName() {return this.studentName;}
    public int getProjectId() {return this.projectId;}
    public String getTitle() {return this.title;}
    public String getSupervisorId() {return this.supervisorId;};
    public String getStudentId() {return this.studentId;};
    public boolean isStatus(ProjectStatus t) {return this.projectStatus.equals(t); }
    
    public boolean isSupervisor(String id) { return id.equals(this.supervisorId); }

    
    /** 
     * @param supervisorId
     * @param studentId
     */
    public void allocate(String supervisorId, String studentId) {
        this.setStudentId(studentId);
        this.setSupervisorId(supervisorId);
        this.supervisorName = DataSystem.getAllUserList().getUser(supervisorId).getName();
        this.studentName = DataSystem.getAllUserList().getUser(this.getStudentId()).getName();
        this.setStatus(ProjectStatus.ALLOCATED);
    }
}

