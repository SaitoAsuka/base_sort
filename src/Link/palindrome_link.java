package Link;

import java.util.Stack;

public class palindrome_link {/*
回文链表*/
    /*三种思路
     * 第一种直接遍历链表，将数据压入栈，依次出栈并和链表对比，如果一样则下一个，不一样则返回false,空间复杂度O（N）
     * 第二种用快慢指针，快指针到头时慢指针到中间，将剩下一半压入栈，再依次出栈对照，空间复杂度O（N），但是较第一种少一半
     * 第三种用快慢指针，快指针到头后，将慢指针后面的链表内容逆序，逆序完成后，并进行对照，最后将链表还原*/
    public void reversedOrder(Node current) {
        Node temp1;
        Node temp2;
        temp1 = current.next.next;
        current.next.next = current;
        current = current.next;
        temp2 = temp1.next;

        while (current.next != null) {
            temp1.next = current;
            current = temp1;
            temp1 = temp2;
            temp2 = temp2.next;
        }
    }
    public static void first_method(Node<String> head){
        Node<String> current = head;
        Stack<String> strings = new Stack<>();
        while (current.next != null) {
            strings.push(current.data);
            current=current.next;
        }
        current = head;
        while (current.next != null) {
            if (strings.pop().equals(current.data)) {
                continue;
            } else {
                System.out.println("该链表不是回文链表");
                return;
            }
        }
    }

}
