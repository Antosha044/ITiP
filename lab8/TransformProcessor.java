import java.util.stream.Stream;

public class TransformProcessor {
    
    @DataProcessor(order = 3, name = "To uppercase")
    public Stream<String> toUpperCase(Stream<String> data) {
        return data.map(String::toUpperCase);
    }
    
    @DataProcessor(order = 4, name = "Add prefix")
    public Stream<String> addPrefix(Stream<String> data) {
        return data.map(s -> "FRUIT: " + s);
    }
}