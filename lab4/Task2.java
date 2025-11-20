import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task2 {
    public static void copyVariant1(String src, String dest) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

            System.out.println("Copy completed successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } catch (IOException e) { 
            System.out.println("IO error during file processing: " + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error closing input file: " + e.getMessage());
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println(" Error closing output file: " + e.getMessage());
                }
            }
        }
    }

    public static void copyVariant2(String src, String dest) {

        try (FileInputStream in = new FileInputStream(src); 
        FileOutputStream out = new FileOutputStream(dest)) {

            int b;
            while (true) {
                try {
                    b = in.read();

                    if (b == -1) {
                        break; 
                    }

                    out.write(b);

                } catch (IOException e) {
                    System.out.println("Read/write error: " + e.getMessage());
                    break;
                }
            }

            System.out.println("Copy completed successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
