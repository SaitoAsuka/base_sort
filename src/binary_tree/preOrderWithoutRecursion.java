package binary_tree;

import java.util.Stack;

/*先序遍历，不通过栈*/
public class preOrderWithoutRecursion {
    public static void order(tree_node current) {
        Stack<tree_node> preOrder = new Stack<>();
        preOrder.push(current);
        while (!preOrder.isEmpty()) {
            current = preOrder.pop();
            if (current.right!= null) {
                preOrder.push(current.right);
            }
            if (current.left != null) {
                preOrder.push(current.left);
            }
            System.out.println(current.data);
        }

    }

    public static void main(String[] args) {
        System.out.println("这是非递归先序遍历");
        tree_node head = preOrder.createTree();
        order(head);
    }
}
