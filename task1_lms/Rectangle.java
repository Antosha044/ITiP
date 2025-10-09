import java.util.Scanner;

public class Rectangle {

    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        System.out.println(rectangleArea(length, width));

        scanner.close();
    }
}
