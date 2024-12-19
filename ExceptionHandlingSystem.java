import java.util.*;

public class ExceptionHandlingSystem {
    public static void main(String[] args) {
        UserDatabase database = new UserDatabase();
        Scanner scanner = new Scanner(System.in);

        // Adding users via input
        try {
            System.out.print("Enter User ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter User Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter User Email: ");
            String email = scanner.nextLine();
            
            database.addUser(new User(id, name, email));

        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException: Invalid input type.");
        }

        // Fetching a user
        try {
            System.out.print("Enter User ID to fetch: ");
            int userId = scanner.nextInt();
            User user = database.getUser(userId);
            System.out.println("Fetched User: " + user.getName() + ", " + user.getEmail());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException: Invalid input type.");
        }

        // File operations
        database.saveToFile("users.txt");
        database.loadFromFile("missingfile.txt"); // This will throw FileNotFoundException

        // Database connection
        database.connectToDatabase("jdbc:invalid:url"); // This will throw SQLException

        System.out.println("System executed with exception handling.");
    }
}
