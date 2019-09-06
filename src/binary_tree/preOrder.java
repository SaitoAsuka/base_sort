package binary_tree;
class tree_node{
    tree_node left;
    tree_node right;
    int data;

    public tree_node(int data) {
        this.data = data;
    }
}
public class preOrder {
    public static void order(tree_node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.data);
        order(current.left);
        order(current.right);
    }
public static tree_node createTree(){
    tree_node tree_node1 = new tree_node(1);
    tree_node tree_node2 = new tree_node(2);
    tree_node tree_node3 = new tree_node(3);
    tree_node tree_node4 = new tree_node(4);
    tree_node tree_node5 = new tree_node(5);
    tree_node tree_node6 = new tree_node(6);
    tree_node tree_node7 = new tree_node(7);
    tree_node1.left = tree_node2;
    tree_node1.right = tree_node3;
    tree_node2.left = tree_node4;
    tree_node2.right = tree_node5;
    tree_node3.left = tree_node6;
    tree_node3.right=tree_node7;
    return tree_node1;
}
    public static void main(String[] args) {
        System.out.println("这是先序遍历");
        tree_node current = createTree();
        order(current);

    }
}
