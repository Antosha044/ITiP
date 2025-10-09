import java.util.Scanner;

public class Days {

    public static String daysToWeeks(int days) {
        int weeks = days / 7;
        int remainingDays = days % 7;

        String weekWord = (weeks == 1) ? "неделя" : "недель";
        
        String dayWord = (remainingDays == 1) ? "день" : "дня";
        if (remainingDays == 0) {
            dayWord = "дней";
        }

        return weeks + " " + weekWord + " и " + remainingDays + " " + dayWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        System.out.println(daysToWeeks(days));
    }
}

