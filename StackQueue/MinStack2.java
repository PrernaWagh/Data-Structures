// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.

import java.util.*;

class MinStack2 {
    Stack<Long> st = new Stack<>();
    long minVal;

    public MinStack2() {}

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            minVal = val;
        } else {
            if (val < minVal) {
                st.push((long)(2L * val - minVal));
                minVal = val;
            } else {
                st.push((long) val);
            }
        }
    }

    public void pop() {
        if (st.peek() < minVal) {
            minVal = 2L * minVal - st.peek();
        }
        st.pop();
    }

    public int top() {
        if (st.peek() < minVal) {
            return (int) minVal;
        }
        return st.peek().intValue();
    }

    public int getMin() {
        return (int) minVal;
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