public class Main {
    public static void main(String[] args) {
        
        DataManager manager = new DataManager();
        
        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new TransformProcessor());
        manager.registerDataProcessor(new AggregateProcessor());
        
        System.out.println();
        
        manager.loadTestData();
        
        System.out.println("\nStart");
        manager.processData();
        
        System.out.println();
        manager.printResults();
        
        manager.saveData("output.txt");
        
    }
}