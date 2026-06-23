class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> temp;

    public MinStack() {
        minStack = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
         return minStack.peek();
    }
    
    public int getMin() {
        
        int min = minStack.peek();

        while (!minStack.isEmpty()) {

            min = Math.min(min, minStack.peek());
            temp.push(minStack.pop());

        }

        while (!temp.isEmpty()) {

            minStack.push(temp.pop());

        }

        return min;
    }
}
