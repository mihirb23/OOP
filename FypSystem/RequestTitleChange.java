package FypSystem;

public class RequestTitleChange extends RequestAction
{
    public String title;
    public int projectId;

    public RequestTitleChange(int projectId, String title) { 
        this.title = title; 
        this.projectId = projectId;
    };
    public void display() {
        System.out.println("Change project " + this.projectId + "\'s title to " + this.title + "." );
    }

    
    /** 
     * @return boolean
     */
    public boolean approve() {
        Project project = DataSystem.allProjectList.projectList.get(projectId);
        project.setTitle(this.title);
        System.out.println("Changed project title.");
        System.out.println("Updated project details.");
        ProjectDisplayManager manager = new ProjectDisplayManager();
        manager.manage(project);
        return true;
    }
    public boolean reject() {return false;}
}

