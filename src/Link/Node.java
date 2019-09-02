package Link;

import java.util.HashMap;

/*链表节点结构*/
public   class  Node<T> {
    public Node random;
    T data;
    Node next = null;

    public Node(T data) {
        this.data = data;
    }

    public void add(Node<T> currentNode,T data) {

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node node = new Node(data);
        currentNode.next = node;
    }

   public void delete(Node<T> currentNode) {
        T temp;
        temp = currentNode.data;
        //*将下一个节点的数据存入当前节点*//*
        currentNode.data = (T) currentNode.next.data;
        currentNode.next.data = temp;
        //*并将当前节点的下一个指针指向下一个节点的的下一个节点*//*
        currentNode.next = currentNode.next.next;
    }

}

