import java.util.Stack;

public class StackToQueue {
    /*如果pop栈如果有元素不允许从push栈交换*/
    /*如果从push栈交换则一定要一次性交换完成*/
    Stack<Integer> StackPush;
    Stack<Integer> StackPop;

    public void push(int newNum) {
        StackPush.push(newNum);
    }

    public void peek() {

    }

    public void change() {
        if (StackPop.isEmpty()) {
            /*如果pop栈没有元素允许从push栈交换*/

            while (StackPush.size() != 0) {
                /*直到push栈中没有元素了为止*/
                StackPop.push(StackPush.pop());

            }
        }
    }

}
