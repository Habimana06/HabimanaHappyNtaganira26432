import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {

    public static void main(String[] args) {
        System.out.println("Checked Exceptions:");
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();

        System.out.println("\nUnchecked Exceptions:");
        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }

    // Checked Exceptions

    // 1. IOException
    public static void handleIOException() {
        try {
            FileReader reader = new FileReader("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 2. FileNotFoundException
    public static void handleFileNotFoundException() {
        try {
            FileReader reader = new FileReader("missingfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException
    public static void handleEOFException() {
        try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(new byte[0]))) {
            dis.readInt(); // Attempting to read beyond the stream
        } catch (EOFException e) {
            System.out.println("EOFException caught: Reached end of file unexpectedly.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 4. SQLException
    public static void handleSQLException() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:invalid:url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    public static void handleClassNotFoundException() {
        try {
            Class.forName("non.existent.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Unchecked Exceptions

    // 6. ArithmeticException
    public static void handleArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: Division by zero.");
        }
    }

    // 7. NullPointerException
    public static void handleNullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to access a null object.");
        }
    }

    // 8. ArrayIndexOutOfBoundsException
    public static void handleArrayIndexOutOfBoundsException() {
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid array index.");
        }
    }

    // 9. ClassCastException
    public static void handleClassCastException() {
        try {
            Object obj = new String("test");
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: Invalid type casting.");
        }
    }

    // 10. IllegalArgumentException
    public static void handleIllegalArgumentException() {
        try {
            Thread.sleep(-1000); // Invalid argument
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: Invalid argument passed.");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught: " + e.getMessage());
        }
    }

    // 11. NumberFormatException
    public static void handleNumberFormatException() {
        try {
            int number = Integer.parseInt("invalid_number");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format.");
        }
    }
}
