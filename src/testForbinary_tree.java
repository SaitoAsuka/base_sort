import binary_tree.node;

public class testForbinary_tree {
    public static node solution(node head) {
        node current = head;
        if (current.right != null) {
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        node parent = current.parent;
        while (parent != null && parent.right == null) {
            current = current.parent;
            parent = current.parent;
        }
        return current;
    }

}
