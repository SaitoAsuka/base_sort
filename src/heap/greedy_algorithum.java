package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*输入：
参数1，正数数组costs 参数2，正数数组profits 参数3， 正数k 参数4，正数m
costs[i]表示i号项目的花费
profits[i]表示i号项目在扣除花 费之后还能挣到的钱(利润)
k表示你不能并行、只能串行的最多 做k个项目
m表示你初始的资金
说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
输出： 你最后获得的最大钱数。*/
public class greedy_algorithum {
    public static Integer greedy_alforithum(int[] cost, int[] profits, int k, int m) {
        PriorityQueue<Integer> small_heap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> big_heap = new PriorityQueue<Integer>(new big_Comparator());
        for (int i = 0; i < cost.length; i++) {
            small_heap.add(cost[i]);
        }
        while (small_heap.peek() <= m) {
            big_heap.add(profits[findSub(cost, small_heap.poll())]);
            if (small_heap.isEmpty()) {
                break;
            }
        }
        System.out.println("本轮成本为" + m);
        System.out.println("在此轮中，满足本钱的前提下，最大收益为" + big_heap.peek());
        return findSub(profits, big_heap.peek());
    }

    public static int findSub(int[] arr, int x) {
        int i = 0;
        while (arr[i] != x) {
            i++;
        }
        return i;
    }

    public static class big_Comparator implements Comparator<Integer> {

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

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        int[] cost = {7, 9, 3, 2, 4};
        int[] profits = {8, 6, 4, 1, 2};
        int k = 2;
        int m = 6;
        for (int i = 0; i < k; i++) {
            int sub_temp = greedy_alforithum(cost, profits, k, m);
            int temp_profits = profits[sub_temp];
            m = m + temp_profits;
            System.out.println(m);
        }

    }
}
