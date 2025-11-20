public class Main {
    public static void main(String[] args) {
        String[] okArray = {"1","2","3","4","5","6"};
        Task1.processArray(okArray);

        String[] badArray = {"1","2","3","ok"};
        Task1.processArray(badArray);

        String src = "input.txt";
        String dest1 = "output_variant1.txt";
        String dest2 = "output_variant2.txt";

        Task2.copyVariant1(src, dest1);
        Task2.copyVariant2(src, dest2);
    }
}
