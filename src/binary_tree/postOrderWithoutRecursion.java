package binary_tree;

import java.util.Stack;

public class postOrderWithoutRecursion {
    public static void order(tree_node head) {
        Stack<tree_node> stack = new Stack<>();
        Stack<tree_node> help_stack = new Stack<>();
        tree_node current = head;

        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            help_stack.push(current);
        }
        while (!help_stack.isEmpty()) {
            System.out.println(help_stack.pop().data);
        }
    }


    public static void main(String[] args) {
        tree_node head = preOrder.createTree();
        order(head);
    }
}
