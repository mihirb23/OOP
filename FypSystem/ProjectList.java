package FypSystem;
import java.util.ArrayList;

public class ProjectList {
    ArrayList<Project> projectList = new ArrayList<Project>();
    public void addProject(Project project) {this.projectList.add(project);}
    public void removeProject(Project project) {this.projectList.remove(project);}
    public Project getProject(int projectId) { return this.projectList.get(projectId); }
    public ArrayList<Project> getProjectList () {return this.projectList;}
    public int getListSize() {return this.projectList.size();}
}
