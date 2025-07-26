package FypSystem;

public class StudentProjectList extends ProjectList {
    public void clear() {
        for (Project t:projectList) {
            t.setStatus(ProjectStatus.AVAILABLE);
            projectList.remove(t);
        }
    }
}
