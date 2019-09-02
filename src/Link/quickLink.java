package Link;

import java.net.Inet4Address;

/*将单向链表按某值划分成左边小、中间相等、右边大的形式*/
public class quickLink {
    public static void partition(Node<Integer> head, int pivot) {
        Node<Integer> smallerh = null;
        Node<Integer> smallert = null;
        Node<Integer> equalh = null;
        Node<Integer> equalt = null;
        Node<Integer> biggerh = null;
        Node<Integer> biggert = null;

        Node<Integer> current = head;
        while (current.next != null) {
            if (biggerh!=null) {
                /*bigger = current;*/
            } else if (smallerh!=null) {
                /*smaller = current;*/
            } else if (equalh!=null) {
                /*equal = current;*/
            }
            current = current.next;
        }
        current = head;
        while (current.next != null) {

        }

    }
}
