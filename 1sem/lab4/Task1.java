public class Task1 {
    public static void processArray(String[] arr) {
        double sum = 0;
        int count = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                double value = Double.parseDouble(arr[i]);
                sum += value;
                count++;
            }
            double average =  sum / count;
            System.out.println("Avg is: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
