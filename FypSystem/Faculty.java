package FypSystem;

public abstract class Faculty extends User {
    private ProjectList supervisingProject;
    private ProjectList myProject;
    public Faculty(String userId, String name, String password) {
        super(userId, name, password);
        supervisingProject = new ProjectList();
        myProject = new ProjectList();
    }
    public abstract void prompt(); 
    public ProjectList getSupervisingProject() {return this.supervisingProject;}
    public ProjectList getMyProject() {return this.myProject; }
    
}
