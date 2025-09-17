public class Task2_normal {
    public static void main(String[] args) {
        for (String s : args) {
            if (isPalindromePointers(s)) {
                System.out.println(s + " is a palindrome");
            } else {
                System.out.println(s + " is not a palindrome");
            }
        }
    }

    // метод с двумя указателями
    public static boolean isPalindromePointers(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
