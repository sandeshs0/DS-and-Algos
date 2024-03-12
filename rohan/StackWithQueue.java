import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // Add the element to queue1
        queue1.add(x);
    }
    
    public int pop() {
        // Move elements from queue1 to queue2 until only one element remains in queue1
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        // Remove the last element from queue1 (which is the top of the stack)
        int poppedElement = queue1.remove();
        
        // Swap queue1 and queue2 so that queue1 always contains elements of the stack
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        // Return the popped element
        return poppedElement;
    }
    
    public int top() {
        // Move elements from queue1 to queue2 until only one element remains in queue1
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        // Get the last element from queue1 (which is the top of the stack)
        int topElement = queue1.peek();
        
        // Move the top element to queue2
        queue2.add(queue1.remove());
        
        // Swap queue1 and queue2 so that queue1 always contains elements of the stack
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        // Return the top element
        return topElement;
    }
    
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
