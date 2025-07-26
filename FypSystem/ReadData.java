package FypSystem;
import java.io.*;
import java.util.*;

public class ReadData {
    public void addUser () {
        String name, id;
        try {
            Scanner sc = new Scanner(new File("./faculty.txt"));
            while (sc.hasNext()){
                name = sc.nextLine().trim();
                id = sc.nextLine().trim();
                Supervisor newUser = new Supervisor(id, name, "password");
                DataSystem.getAllUserList().addUser(newUser);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File error! " + e.getMessage());
            System.exit(0);
        }
        try {
            Scanner sc = new Scanner(new File("./student.txt"));
            while (sc.hasNext()){
                name = sc.nextLine().trim();
                id = sc.nextLine().trim();
                Student newUser = new Student(id, name, "password");
                DataSystem.getAllUserList().addUser(newUser);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File error! " + e.getMessage());
            System.exit(0);
        }
        try {
            Scanner sc = new Scanner(new File("./coordinator.txt"));
            while (sc.hasNext()){
                name = sc.nextLine().trim();
                id = sc.nextLine().trim();
                Coordinator newUser = new Coordinator(id, name, "password");
                User tuser = DataSystem.allUserList.getUser(id);
                if ( tuser != null ) {
                    DataSystem.getAllUserList().remove(tuser);
                }
                DataSystem.getAllUserList().addUser(newUser);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File error! " + e.getMessage());
            System.exit(0);
        }
        
    }
    public void addProject() {
        String name, title, id;
        try {
            Scanner sc = new Scanner(new File("./project.txt"));
            while (sc.hasNext()){
                name = sc.nextLine().trim();
                title = sc.nextLine().trim();
                id = DataSystem.getAllUserList().getIdWithName(name);
                Faculty faculty = (Faculty) DataSystem.allUserList.getUser(id);
                Project project = new Project(title, id, DataSystem.getAllProjectList().getListSize());
                faculty.getMyProject().addProject(project);
                DataSystem.getAllProjectList().addProject(project);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File error! " + e.getMessage());
            System.exit(0);
        }
    }
}
