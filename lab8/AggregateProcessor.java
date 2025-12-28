import java.util.stream.Stream;

public class AggregateProcessor {
    
    @DataProcessor(order = 5, name = "Remove duplicates")
    public Stream<String> removeDuplicates(Stream<String> data) {
        return data.distinct();
    }
    
    @DataProcessor(order = 6, name = "Sort alphabetically")
    public Stream<String> sortAlphabetically(Stream<String> data) {
        return data.sorted();
    }
    
    @DataProcessor(order = 7, name = "Limit results")
    public Stream<String> limitResults(Stream<String> data) {
        return data.limit(5);
    }
}