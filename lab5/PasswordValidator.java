import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {

        String password = "Abcdef12"; 

        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Password is correct");
            } else {
                System.out.println("Incorrect password");
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Regex error: " + e.getMessage());
        } 
    }
}
