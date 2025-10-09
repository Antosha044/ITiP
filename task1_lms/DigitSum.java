import java.util.Scanner;

public class DigitSum {

    public static int digitSum(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number > 0) {
            sum += number % 10; 
            number /= 10;      
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        System.out.println(digitSum(number));

        scanner.close();
    }
}
