import java.util.stream.Stream;

public class FilterProcessor {
    
    @DataProcessor(order = 1, name = "Length filter")
    public Stream<String> filterByLength(Stream<String> data) {
        return data.filter(s -> s.length() > 4);
    }
    
    @DataProcessor(order = 2, name = "Letter filter")
    public Stream<String> filterByLetter(Stream<String> data) {
        return data.filter(s -> s.toLowerCase().contains("a"));
    }
}