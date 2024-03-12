import java.util.Stack;

public class Queue {

    private Stack<Integer> stack;

    public Queue() {
        this.stack = new Stack<>();
    }

    int size() {
        return stack.size();
    }

    boolean isEmpty() {
        return stack.size() == 0;
    }

    void offer(int val) {
        stack.pop();
    }

    Integer poll() {
        if (stack.isEmpty()) {
            return null;
        }
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int result = tempStack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return result;
    }
}