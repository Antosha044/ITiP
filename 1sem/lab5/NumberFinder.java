import java.util.regex.*;

public class NumberFinder {

    public static void main(String[] args) {

        String text = "The price of the product is $19.99 and the id is 12345";

        try {
            Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");

            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Regex error: " + e.getMessage());
        }
    }
}
