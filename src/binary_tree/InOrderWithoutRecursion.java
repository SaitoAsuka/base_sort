package binary_tree;

import java.util.Stack;

public class InOrderWithoutRecursion {
    public static void order(tree_node head) {
        Stack<tree_node> stack = new Stack<>();
        tree_node current = head;

        while (!stack.isEmpty()||current!=null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                /*将指针退回到上一层，即栈顶不为空的元素*/
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("/*这是不使用递归地中序遍历*/");
        tree_node head = preOrder.createTree();
        order(head);
    }
}
