import java.util.regex.*;

public class WordsStartingWithLetter {
    public static void main(String[] args) {

        String text = "Apple apricot Banana berry Cherry chocolate date";

        char letter = 'a';

        String patternStr = "\\b[" + Character.toUpperCase(letter) + Character.toLowerCase(letter) + "]\\w*";

        try {
            Pattern pattern = Pattern.compile(patternStr);

            Matcher matcher = pattern.matcher(text);

            System.out.println("Words starting with '" + letter + "':");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Regex error: " + e.getMessage());
        } 
    }
}
