package Link;

import java.util.HashSet;

public class findFirstIntersectNode {
    /*获取链表中第一个环节点
     * 通过将节点依次放入set中，set中的元素具有唯一性
     * 再循环中进行判断，如果set中已包含下一节点，说明当前节点为环的起始节点*/
    public static Node<Integer> getFirstLoopNodeBySet(Node<Integer> head) {
        Node<Integer> current = head;
        HashSet<Node<Integer>> set = new HashSet<>();
        set.add(current);
        while (current != null) {
            if (set.contains(current.next)) {
                return current;
            }
            set.add(current.next);
            current = current.next;
        }
        return null;
    }

    /*用快慢指针，快指针一次走两步，慢指针一次走一步，直到快指针与慢指针相遇
     * 快指针回到开头，并且每次步进一个，直到快慢指针再次相遇
     * 两指针相遇位置即为循环起始节点*/
    public static Node<Integer> getFisrtLoopWithoutSet(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> fastPoint = head;
        Node<Integer> slowPoint = head;
        while (fastPoint != slowPoint) {
            if (fastPoint.next.next == null || fastPoint.next == null) {
                return null;
            }
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        fastPoint = head;
        while (fastPoint != slowPoint) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
        }
        return fastPoint;
    }

    /*第二步判断链表重合的部分
     * 使用set的方法*/
    public static Node<Integer> getDoublicationPartBySet(Node<Integer> head1, Node<Integer> head2) {
        HashSet<Integer> set = new HashSet<>();
        Node<Integer> cur_link1 = head1;
        Node<Integer> cur_link2 = head2;
        Node<Integer> tail_link1 = null;
        Node<Integer> tail_link2 = null;
        int link1_length = 0;
        int link2_length = 0;
        /************************************************************/
        while (cur_link1 != null) {
            set.add(cur_link1.data);
            link1_length++;
            if (cur_link1.next == null) {
                tail_link1 = cur_link1;
            }
            cur_link1 = cur_link1.next;
        }
        while (cur_link2 != null) {
            link2_length++;
            if (cur_link2.next == null) {
                tail_link2 = cur_link2;
            }
            cur_link2 = cur_link2.next;
        }
        /*不使用hashset的时候，需要得到两个链表的差值，但没必要同时得到两个链表的长度*/
/*        int n=0;
        cur_link1 = head1;
        while (cur_link1.next != null) {
            n++;
            cur_link1 = cur_link1.next;
        }
        cur_link2 = head2;
        while (cur_link2.next != null) {
            n--;
            cur_link2 = cur_link2.next;
        }*/
/*在该方法中仅需要遍历一遍链表，第二个链表无论长短，都是从头遍历的，假如第一个链表长，则剩余的数即为两链表长度之差，*/
        /**************************************************/
        int longest_length = link1_length > link2_length ? link1_length : link2_length;
        if (tail_link1 != tail_link2) {
            return null;
        }
        cur_link1 = head1;
        cur_link2 = head2;
        if (link1_length == longest_length) {
            while (!set.contains(cur_link1.data)) {
                cur_link1 = cur_link1.next;
            }
            return cur_link1;
        } else {
            while (!set.contains(cur_link2.data)) {
                cur_link2 = cur_link2.next;
            }
            return cur_link2;
        }

    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getDoublicationPartBySet(head1, head2).data);

    }
}
