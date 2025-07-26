package FypSystem;

public class RequestReallocateStudent extends RequestAction {

    private String newSupervisorId;
    private Project project;
    public RequestReallocateStudent(Project project, String newSupervisorId) {
        this.project = project;
        this.newSupervisorId = newSupervisorId;
    }
    
    /** 
     * @return boolean
     */
    public boolean approve() {
        Faculty supervisor = (Faculty) DataSystem.allUserList.getUser(project.getSupervisorId());
        Faculty supervisor1 = (Faculty) DataSystem.getAllUserList().getUser(this.newSupervisorId);
        if ( supervisor1.getSupervisingProject().getListSize()==2 ) {
            System.out.println("Replacement supervisor has reached cap.");
            return false;
        }
        supervisor.getSupervisingProject().removeProject(this.project);
        supervisor.getMyProject().removeProject(this.project);
        if ( supervisor.getSupervisingProject().getListSize() == 1 ) {
            Project tproject1 = supervisor.getSupervisingProject().getProject(0);
            for( Project tproject: supervisor.getSupervisingProject().getProjectList() ) 
                if ( !tproject.equals(tproject1))  tproject.setStatus(ProjectStatus.AVAILABLE);
        }

        project.setSupervisorId(newSupervisorId);
        supervisor1.getSupervisingProject().addProject(this.project);
        supervisor1.getMyProject().addProject(this.project);
        if ( supervisor1.getSupervisingProject().getListSize()==2 ) {
            for( Project tproject: supervisor1.getSupervisingProject().getProjectList() )  {
                if ( tproject.isStatus(ProjectStatus.AVAILABLE)) 
                    tproject.setStatus(ProjectStatus.UNAVAILABLE); 
            }
        }
        return true;
    }
    public boolean reject(){ return false; }

    public void display() {
        Faculty supervisor1 = (Faculty) DataSystem.allUserList.getUser(project.getSupervisorId());
        Faculty supervisor2 = (Faculty) DataSystem.allUserList.getUser(this.newSupervisorId);
        System.out.println("Reallocate project "+project.getTitle()+" by supervisor " + supervisor1.getName()+ " to replacement supervisor: " + supervisor2.getName());
    
    }
}