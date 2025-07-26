package FypSystem;

public class ProjectDisplayManager extends DisplayManager {
    
    
    /** 
     * @param o
     */
    public void manage(Object o) {
        ProjectDisplay projectDisplay = new ProjectDisplay();
        projectDisplay.display((Project)o);
    }
}
