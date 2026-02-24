public class Task2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " - is a palindrome");
            } else {
                System.out.println(s + " - is not a palindrome");
            }
        }
    }

    public static String reverseSting(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseSting(s));
    }
}