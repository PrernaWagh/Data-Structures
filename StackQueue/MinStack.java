

import java.util.Stack;

class MinStack {
    class Pair{  
        int val;
        int min;

        Pair(int val,int min)
        {
            this.val = val;
            this.min = min;
        }
    }
    Stack<Pair> st = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.empty())
        {
            st.push(new Pair(val,val));
        }
        else{
            int mini = Math.min(val,st.peek().min);
            st.push(new Pair(val,mini));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */