public class Main {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        try {
            stack.pop();
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
            ExceptionLogger.log(e);
        }
    }
}