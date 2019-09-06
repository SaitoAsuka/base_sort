package binary_tree;

public class Inorder {
    public static void order(tree_node current) {
        if (current == null) {
            return;
        }
        order(current.left);
        System.out.println(current.data);
        order(current.right);

    }

    public static void main(String[] args) {
        System.out.println("这是中序遍历");
        tree_node current = preOrder.createTree();
        order(current);

    }
}