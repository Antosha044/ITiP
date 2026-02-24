import java.util.regex.*;

public class CapitalAfterLower {
    public static void main(String[] args) {

        String text = "abC hGhC"; 

        try {
            Pattern pattern = Pattern.compile("(?<=[a-z])(?=[A-Z])");

            Matcher matcher = pattern.matcher(text);
            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                matcher.appendReplacement(result, "!" + matcher.group() + "!");
            }
            matcher.appendTail(result);

            System.out.println(result.toString());

        } catch (PatternSyntaxException e) {
            System.out.println("Regex error" + e.getMessage());
        } 
    }
}
