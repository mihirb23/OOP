package FypSystem;

public class RequestDeregister extends RequestAction {
    public String studentId;
    public RequestDeregister(String studentId){
        this.studentId = studentId;
    }
    
    public void display() {System.out.println("Student request to deregister FYP.");} ;

    
    /** 
     * @return boolean
     */
    public boolean approve() {
        Student student = (Student) DataSystem.getAllUserList().getUser(this.studentId);
        for ( Project project: student.getMyProjectList().getProjectList()) {
            project.setStatus(ProjectStatus.AVAILABLE);
            Supervisor supervisor = (Supervisor) DataSystem.getAllUserList().getUser(project.getSupervisorId());
            supervisor.getSupervisingProject().removeProject(project);
            if ( supervisor.getSupervisingProject().getListSize()==1 ){
                for ( Project tproject:supervisor.getSupervisingProject().getProjectList()) {
                    if ( !tproject.equals(project) ) tproject.setStatus(ProjectStatus.AVAILABLE);
                }
            }
            project.setStudentId(null);
        }
        student.setStatus(StudentStatus.DEREGISTER);
        return true;
    }
    public boolean reject(){ return false;};
}