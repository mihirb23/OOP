package FypSystem;

public class RequestAllocation extends RequestAction {
    public Project project;
    private String studentId;
    public RequestAllocation(Project project, String studentId) { 
        this.project = project;
        this.studentId = studentId;
    };

    public void display() { 
        System.out.println("Allocate project \'"+project.getTitle()+"\' by supervisor " + project.getSupervisorId()+ " to student " + this.studentId +"."); 
    }
    
    /** 
     * @return boolean
     */
    public boolean approve() {
        boolean b = true;
        Student student = (Student) DataSystem.allUserList.getUser(this.studentId);
        Faculty supervisor = (Faculty) DataSystem.allUserList.getUser(project.getSupervisorId());
        if ( supervisor.getSupervisingProject().getListSize() >= 2 ) {
            System.out.println("Supervisor is supervising 2 projects, cap reached.");
            b =  false;
        }
        if (  student.isStatus(StudentStatus.HAVEPROJECT) ){
            System.out.println("Student have been allocated project already, cannot allocate.");
            b =  false;
        }
        if ( student.isStatus(StudentStatus.DEREGISTER) ) {
            System.out.println("Student have deregister FYP.");
            b = false;
        }
        if ( !project.isStatus(ProjectStatus.AVAILABLE) ){
            System.out.println("Project isn't available.");
            b = false;
        }
        if (b) {
            //System.out.println("Approve request"); 
            supervisor.getSupervisingProject().addProject(project);
            if ( supervisor.getSupervisingProject().getListSize() == 2 ) {
                for ( Project tproject: supervisor.getMyProject().getProjectList()){
                    if ( tproject.isStatus(ProjectStatus.AVAILABLE)) tproject.setStatus(ProjectStatus.UNAVAILABLE);
                }
            }
            student.getMyProjectList().addProject(project);

            student.setStatus(StudentStatus.HAVEPROJECT);
            project.allocate(supervisor.getUserId(), studentId);
        }
        return b;
    }
    
    public boolean reject() { return false;} ;
}


