package FypSystem;
import java.util.*;

public class App {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        ReadData readData = new ReadData();
        readData.addUser();
        readData.addProject();
        Scanner sc = new Scanner(System.in);
        LoginInterface loginInterface = new LoginInterface();
        UserInterface userInterface = new UserInterface();

        User user = null;
        String input;
        int choice = 0;

        System.out.println("==============================================");
        System.out.println("Welcome to FYP system.");
        System.out.println("----------------------------------------------");
        System.out.print("Enter 'exit' to exit or input any other INTEGER to login : ");
        input = sc.next().trim();
        System.out.println();
        
        while ( !input.equals("exit") ) {
            try {
                choice = Integer.parseInt(input);
                user = loginInterface.getUser();
                if ( user != null ) {
                    userInterface.promptUser(user);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Input a integer");
                choice = 0;
            }
            System.out.println("----------------------------------------------");
            System.out.print("Enter \'exit\' to exit or input any other INTEGER to login: ");
            input = sc.next().trim();
            System.out.println();
        }
        System.out.println("Exiting FYP system.");
    }
}
