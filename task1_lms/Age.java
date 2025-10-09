import java.util.Scanner;

public class Age {
    public static String checkAge(int age) {
        if (age >= 18) {
            return "совершеннолетний";
        } else {
            return "несовершеннолетний";
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int age = sc.nextInt();
            System.out.println(checkAge(age));
        }
    }
}
