package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*找到数据流的中位数，一个不断输出证书的数据流，设计结构，随时取得之前得到的书的中位数*/
public class MedianHolder {
    /*需要随时取得之前数的中位数，即需要插入即排序，
    使用两个堆结构，一个小根堆，一个大根堆，并且不断调整两个堆大小的平衡，差距不大于1
    堆顶的元素就是中位数
    在java中priorityqueue即优先级队列就是小根堆结构，通过比较器，能将其逆转为大根堆结构*/
    public static class largeComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }
    }


    public static void insertNum(int x, PriorityQueue<Integer> largeRootHeap, PriorityQueue<Integer> smallRootHeap) {
        int dep_deference = largeRootHeap.size() > smallRootHeap.size() ? largeRootHeap.size() - smallRootHeap.size() : smallRootHeap.size() - largeRootHeap.size();
        if (dep_deference > 1) {
            int temp = 0;
            if (largeRootHeap.size() > smallRootHeap.size()) {
                temp = largeRootHeap.poll();
                smallRootHeap.add(temp);
            } else {
                temp = smallRootHeap.poll();
                largeRootHeap.add(temp);
            }
        }
        if (largeRootHeap.peek() == null) {
            largeRootHeap.add(x);
        } else if (x > largeRootHeap.peek()) {
            smallRootHeap.add(x);
        } else {
            largeRootHeap.add(x);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> largeRootHeap = new PriorityQueue<>(new largeComparator());
        PriorityQueue<Integer> smallRootHeap = new PriorityQueue<>();
        insertNum(7, largeRootHeap, smallRootHeap);
        insertNum(9, largeRootHeap, smallRootHeap);
        insertNum(3, largeRootHeap, smallRootHeap);
        insertNum(2, largeRootHeap, smallRootHeap);
        insertNum(10, largeRootHeap, smallRootHeap);
        insertNum(8, largeRootHeap, smallRootHeap);
        insertNum(4, largeRootHeap, smallRootHeap);
        System.out.println(largeRootHeap.peek());
        System.out.println(smallRootHeap.peek());
        System.out.println("*************************************");
        while (largeRootHeap.size() != 0) {
            System.out.println(largeRootHeap.poll());
        }
        System.out.println("*************************************");

        while (smallRootHeap.size() != 0) {
            System.out.println(smallRootHeap.poll());
        }

    }
}

