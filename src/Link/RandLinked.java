package Link;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

class myNode<T> extends Node<T> {
    myNode<T> random = null;
    public myNode(T data) {
        super(data);
    }
}
public class RandLinked {
/*使用map拷贝链表
* map中对应的键值对是原节点和拷贝节点，通过遍历map，将原节点的节点关系复刻到拷贝链表上*/
    public static myNode<Integer> copyLinked(myNode<Integer> head) {
        HashMap<myNode<Integer>, myNode<Integer>> map = new HashMap<>();
        myNode<Integer> current = head;

        while (current!= null) {
            map.put(current, new myNode<>(current.data));
            current = (myNode<Integer>) current.next;
        }
        current = head;
        while (current!= null) {
            map.get(current).next = current.next;
            map.get(current).random = current.random;
        }
        return map.get(head);

    }
/*在不使用map的情况下，拷贝链表
* 分为三步，第一步将拷贝节点接到原节点后面
*           第二步将原节点的节点关系复刻到拷贝节点上
*           第三步将两个链表分离*/
    public static myNode<Integer> copyLinked_withoutMap(myNode<Integer> head) {
        myNode<Integer> current = head;
        /*第一步，将拷贝节点挂到原节点的后面*/
        while (current != null) {
            myNode<Integer> temp = (myNode<Integer>) current.next;
            current.next = new myNode(current.data);
            current.next.next=temp;
            current = (myNode<Integer>) current.next.next;
        }
        /*第二步，将random属性指向对应的拷贝节点*/
        current = head;
        while (current!= null) {
            current.next.random = current.random.next;
            current = (myNode<Integer>) current.next.next;
        }
        /*分离拷贝节点，形成拷贝链表*/
        Node<Integer> copyLinked_head=current.next;
        Node<Integer> copyLinked_current = copyLinked_head;
        while (current != null) {
            Node<Integer> temp = current.next;
            current.next = current.next.next;
            copyLinked_current.next = temp;
            copyLinked_current = copyLinked_current.next;
            current = (myNode<Integer>) current.next;
        }
        return (myNode<Integer>) copyLinked_head.next;
    }

}
