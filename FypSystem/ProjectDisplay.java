package FypSystem;

public class ProjectDisplay extends Display{
    public ProjectDisplay() {};
    
    /** 
     * @param o
     */
    public  void display(Object o) {
        Project project = (Project) o;
        System.out.println("----------------------------------------------");
        System.out.println("Project ID: " + project.getProjectId());
        System.out.println("Project title: " + project.getTitle());
        String supervisorId = project.getSupervisorId();
        System.out.println("Supervisor name: " + DataSystem.allUserList.getUser(supervisorId).getName());
        System.out.println("Supervisor email: " + supervisorId + "@ntu.edu.sg");
        if ( project.isStatus(ProjectStatus.AVAILABLE) ){
            System.out.println("projectStatus: Available" );
        }
        else if ( project.isStatus(ProjectStatus.ALLOCATED)) {      
            System.out.println("projectStatus: Allocated");
            String studentId = project.getStudentId();
            System.out.println("Student name: "+ DataSystem.allUserList.getUser(studentId).getName());
            System.out.println("Student email: "+ project.getStudentId()+"@e.ntu.edu.sg");
        }
        else if ( project.isStatus(ProjectStatus.UNAVAILABLE)) {
            System.out.println("projectStatus: Unavailable");
        }
        System.out.println("----------------------------------------------");
    }
}

