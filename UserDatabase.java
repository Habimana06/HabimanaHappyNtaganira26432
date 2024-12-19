import java.io.*;
import java.sql.*;
import java.util.*;

class UserDatabase {
    private Map<Integer, User> users;

    public UserDatabase() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(int userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new NullPointerException("User not found."); // Demonstrates NullPointerException
        }
        return user;
    }

    public void saveToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (User user : users.values()) {
                writer.write(user.getId() + "," + user.getName() + "," + user.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to write to file.");
        }
    }

    public void loadFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new EOFException("Invalid file format."); // Demonstrates EOFException
                }
                addUser(new User(Integer.parseInt(parts[0]), parts[1], parts[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: File not found.");
        } catch (IOException e) {
            System.out.println("IOException: Error reading file.");
        }
    }

    public void connectToDatabase(String url) {
        try {
            Connection conn = DriverManager.getConnection(url, "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException: Failed to connect to the database."); // Demonstrates SQLException
        }
    }
}
