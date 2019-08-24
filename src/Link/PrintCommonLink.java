package Link;

import com.sun.security.auth.NTDomainPrincipal;

/*打印一个有序链表公共的部分*/


public class PrintCommonLink {

    public static void findCommon(Node a, Node b) {
        /*打印两个链表的公共部分，用两个指针，对比两个指针指的节点内容，谁小谁就跳到下一个，如果一样则打印，并且共同跳到下一个
         * 如果有一个链表到头则结束*/

        while (a != null && b != null) {
            if (Integer.parseInt(a.data) > Integer.parseInt(b.data)) {
                b = b.next;
            } else if (Integer.parseInt(a.data) == Integer.parseInt(b.data)) {
                System.out.println(a.data);
                a = a.next;
                b = b.next;
            } else {
                a =a.next;
            }
        }
    }

    public static void main(String[] args) {
        Node a_head = new Node("1");
        Node node = new Node("2");
        Node node1 = new Node("3");
        Node node2 = new Node("4");
        a_head.next = node;
        node.next = node1;
        node1.next = node2;
        Node b_head = new Node("1");
        Node node4 = new Node("3");
        Node node5 = new Node("4");
        Node node6 = new Node("7");
        b_head.next = node4;
        node4.next = node5;
        node5.next=node6;
        findCommon(a_head,b_head);

    }
}
