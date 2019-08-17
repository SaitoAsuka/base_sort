import java.util.Queue;

public class QueueToStack {
    Queue<Integer> queue;
    Queue<Integer> help;

    public void push(Integer newNum) {
        queue.add(newNum);
    }

    public Integer pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("该栈为空");
        }
/*
        for (int i = 0; i < queue.size()-1; i++) {
            help.add(queue.poll());
        }
*/
        /*直到队列中只剩下一个数的时候停止*/
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();/*交换引用*/
        return res;
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("该栈为空");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        queue.add(res);

        return res;
    }

    /*将引用交换，
    queue指向help的内存，help指向queue的内存*/
    public void swap() {
        Queue<Integer> temp = this.queue;
        queue = help;
        help = temp;
    }
}
