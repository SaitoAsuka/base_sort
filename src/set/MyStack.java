package set;

import java.util.Stack;

/*要求：设计栈，可以使用系统自带栈
 * 实现pull，getmin等方法
 * 时间复杂度要为O（1）*/
public class MyStack {
    private Stack<Integer> DataStack;
    private Stack<Integer> minStack;

    public void push(int newNum) {
        int lastMin = this.getMin();
        if (minStack.isEmpty()) {
            minStack.push(newNum);
        } else if (newNum <= lastMin) {
            this.DataStack.push(newNum);
            this.minStack.push(newNum);

        } else {
            this.minStack.push(lastMin);
        }

    }

    public Integer getMin() {
        return minStack.peek();
    }

    public Integer pop() {
        if (DataStack.isEmpty()) {
            throw new RuntimeException("该栈为空");
        }
        minStack.pop();
        return DataStack.pop();
    }
}




