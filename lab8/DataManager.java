import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class DataManager {
    private List<String> rawData;
    private List<String> processedData;
    private List<Object> processors;
    
    public DataManager() {
        this.processors = new ArrayList<>();
        this.rawData = new ArrayList<>();
        this.processedData = new ArrayList<>();
    }
    
    public void registerDataProcessor(Object processor) {
        boolean hasAnnotation = Arrays.stream(processor.getClass().getMethods())
                .anyMatch(method -> method.isAnnotationPresent(DataProcessor.class));
        
        if (hasAnnotation) {
            processors.add(processor);
            System.out.println("Registered processor: " + processor.getClass().getSimpleName());
        } else {
            System.out.println("Class " + processor.getClass().getSimpleName() + 
                             " has no methods with @DataProcessor annotation");
        }
    }
    
    public void loadData(String source) {
        try {
            rawData = Files.readAllLines(Paths.get(source));
            System.out.println("Loaded " + rawData.size() + " lines from file: " + source);
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
            rawData = new ArrayList<>();
        }
    }
    
    public void loadTestData() {
        rawData = Arrays.asList(
            "apple", "banana", "orange", "pear", "peach",
            "kiwi", "mango", "grape", "watermelon", "melon",
            "strawberry", "raspberry", "blackberry", "plum", "apricot"
        );
        System.out.println("Loaded test data: " + rawData.size() + " fruits");
    }
    
    @SuppressWarnings("unchecked")
    public void processData() {
        if (rawData.isEmpty()) {
            System.out.println("No data to process");
            return;
        }
        
        if (processors.isEmpty()) {
            System.out.println("No registered processors");
            processedData = new ArrayList<>(rawData);
            return;
        }
        
        List<MethodInfo> methodsToExecute = new ArrayList<>();
        
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    DataProcessor annotation = method.getAnnotation(DataProcessor.class);
                    methodsToExecute.add(new MethodInfo(processor, method, annotation));
                }
            }
        }
        
        methodsToExecute.sort(Comparator.comparingInt(m -> m.annotation.order()));
        
        Stream<String> dataStream = rawData.stream();
        
        for (MethodInfo methodInfo : methodsToExecute) {
            String processorName = methodInfo.annotation.name().isEmpty() ? 
                    methodInfo.method.getName() : methodInfo.annotation.name();
            System.out.println("Applying processor: " + processorName + " (order: " + 
                    methodInfo.annotation.order() + ")");
            
            try {
                dataStream = (Stream<String>) methodInfo.method.invoke(methodInfo.processor, dataStream);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println("Start");
        processedData = dataStream.parallel().collect(Collectors.toList());
        
        System.out.println("Complete");
    }
    
    public void saveData(String destination) {
        try {
            Files.write(Paths.get(destination), processedData);
            System.out.println("Data saved to file: " + destination);
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }
    }
    
    public void printResults() {    
        processedData.forEach(System.out::println);
    }
    
    private static class MethodInfo {
        Object processor;
        Method method;
        DataProcessor annotation;
        
        MethodInfo(Object processor, Method method, DataProcessor annotation) {
            this.processor = processor;
            this.method = method;
            this.annotation = annotation;
        }
    }
}