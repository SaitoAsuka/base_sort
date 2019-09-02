package Link;

import com.sun.security.auth.NTDomainPrincipal;

/*打印一个有序链表公共的部分*/


public class PrintCommonLink {

    public static void findCommon(Node<Integer> a, Node<Integer> b) {
        /*打印两个链表的公共部分，用两个指针，对比两个指针指的节点内容，谁小谁就跳到下一个，如果一样则打印，并且共同跳到下一个
         * 如果有一个链表到头则结束*/

        while (a != null && b != null) {
            if (a.data > b.data) {
                b = b.next;
            } else if (a.data == b.data) {
                System.out.println(a.data);
                a = a.next;
                b = b.next;
            } else {
                a =a.next;
            }
        }
    }

    public static void main(String[] args) {

        Node<Integer> head = null;
        /*head= head.add(head,1);*/
        head.add(head, 3);
        head.add(head, 7);
        head.add(head, 13);
        Node<Integer> currentNode = head;
        while (currentNode.next != null) {
            System.out.println(currentNode.data);
            currentNode=currentNode.next;
        }


    }
}
