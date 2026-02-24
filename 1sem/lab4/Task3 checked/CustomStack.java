import java.util.ArrayList;
import java.util.List;

public class CustomStack {

    private List<Integer> stack = new ArrayList<>();

    public void push(int value) {
        stack.add(value);
    }

    public int pop() throws CustomEmptyStackException {
        if (stack.isEmpty()) {
            throw new CustomEmptyStackException("Attempt to pop from empty stack");
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
