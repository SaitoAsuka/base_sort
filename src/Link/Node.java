package Link;
/*链表节点结构*/
public class Node {
    String data;
    Node next = null;

    public Node(String data) {
        this.data = data;
    }

    public void add(String data) {
        this.next = new Node(data);
    }

    public void delete(Node current) {
        String temp;
        temp = current.data;
        /*将下一个节点的数据存入当前节点*/
        current.data = current.next.data;
        current.next.data = temp;
        /*并将当前节点的下一个指针指向下一个节点的的下一个节点*/
        current.next = current.next.next;
    }
}

