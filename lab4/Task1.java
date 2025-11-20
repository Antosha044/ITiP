public class Task1 {
    public static void processArray(String[] arr) {
        int sum = 0;
        int count = 0;
        try {
            for (int i = 0; i <= arr.length; i++) {
                int value = Integer.parseInt(arr[i]);
                sum += value;
                count++;
            }
            double average = (double) sum / count;
            System.out.println("Avg is: ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
