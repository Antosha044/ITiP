import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {

    private static final String LOG_FILE = "exceptions.log";

    public static void log(Exception e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("Exception: " + e.getClass().getName());
            pw.println("Message: " + e.getMessage());
            pw.println("Stack trace:");
            e.printStackTrace(pw);
            pw.println("------------------------------------------------");

        } catch (IOException ioEx) {
            System.out.println("Failed to write exception to log file: " + ioEx.getMessage());
        }
    }
}
