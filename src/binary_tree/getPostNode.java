package binary_tree;

/*获取当前节点的后继节点
 * 节点结构为数据，父节点，左子节点，右子节点
 * 后继节点为中序遍历时，该节点的后继节点*/
public class getPostNode {
    public static node getPostNode(node current) {
        if (current == null) {
            return current;
        }
        if (current.right != null) {
            /*如果当前节点的右子树不为空，则该节点的后继为右子节点或右子节点的最左子节点*/
            return getLeftNode(current);
        } else {
            node parrent = current.parrent;
            /*当右子树为空，寻找该节点父节点及以上，若存在
             * 某节点为上一节点的左孩子，则该节点为目标节点的后继节点。*/
            while (parrent.left != current && parrent != null) {
                /*current节点不断向上追溯*/
                current = parrent;
                parrent = current.parrent;
            }
            return current;
        }

    }

    private static node getLeftNode(node current) {
        if (current == null) {
            return current;
        }
        while (current.left != null) {
            current = current.left;
        }
        return current;

    }
}

