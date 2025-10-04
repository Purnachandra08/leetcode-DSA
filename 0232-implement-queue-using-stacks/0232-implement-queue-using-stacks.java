import java.util.Stack;

class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    // Push element x to the back of queue
    public void push(int x) {
        inputStack.push(x);
    }
    
    // Removes the element from in front of queue and returns that element
    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }
    
    // Get the front element
    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }
    
    // Returns whether the queue is empty
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Helper method to transfer elements from input to output stack
    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
