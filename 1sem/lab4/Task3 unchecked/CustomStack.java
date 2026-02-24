import java.util.ArrayList;
import java.util.List;

public class CustomStack {

    private List<Integer> stack = new ArrayList<>();

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (stack.isEmpty()) {
            CustomEmptyStackRunTimeException e = new CustomEmptyStackRunTimeException("Attempt to pop from empty stack");
            ExceptionLogger.log(e);
            throw e;

        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
