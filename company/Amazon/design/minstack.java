class MinStack {

    Stack<Integer> stack = new Stack();
    Stack<Integer> min_stack = new Stack();
    
    public void push(int x) {
        
        // need a check to insert in minstack as well if its min or if no emelent is present we push init value to. minstack
        if(min_stack.isEmpty() || x <= min_stack.peek()){
            min_stack.push(x);
        }
        
        stack.push(x);
        
        
    }
    
    public void pop() {
        // we need to pop from both minstack and regular stack
        // if whatever popping from regular stack , if that is min value then u also need to pop from min since u might have pushed becos it is min

        if(stack.peek().equals(min_stack.peek())){
            min_stack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
         return min_stack.peek();
    }
}


// T: 0(1)
// S: 0(n)
// extra space 

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


// //  using single stack:
// we remove the need for stack extra but the min values we insert will not be orfderd



 class MinStack {

    Stack<Integer> stack = new Stack();
    
    int min  = Integer.MAX_VALUE;
    // Stack<Integer> min_stack = new Stack();
    
    public void push(int x) {
        
        // need a check to insert in minstack as well if its min or if no emelent is present we push init value to. minstack
//         if(min_stack.isEmpty() || x <= min_stack.peek()){
//             min_stack.push(x);
//         }
        
        //push 
        // if its lesst than min then we push the min first , update the min  and also we will push the latest min as a regular stack push
        // we are havingin order old min and then new min in stack 
        if(x <= min){
           stack.push(min);
           min = x; 
        }
        
        stack.push(x);
        
        
    }
    
    public void pop() {
        // we need to pop from both minstack and regular stack
        // we remove from misntack only if the current element we are peeking is also the top of the stcl in both
        // if(stack.peek().equals(min_stack.peek())){
        //     min_stack.pop();
        // }
        if(stack.pop() == min)
            min = stack.pop();
        // here even in loop fails the condition , stack actuallys pops off  so if condition is met like its a min then it removes the min element and also updates the min with next old min and also removes it 
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
         return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */