/*
public class bucketSort {
    */
/*arr数组中为0~200的数，设置长度为201的数组，统计每个下标出现的词频*//*

    public static void bucketSort(int[] arr) {
*/
/*
        int[] help = new int[200];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
*//*

        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        */
/*整形类型的范围
 *该方法会返回最小的整型即：-2147483648*//*

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);*/
/*遍历比较得到数组中的最大值*//*

        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        */
/*排序*//*

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (bucket[i]-- > 0) {
                arr[j++] = bucket[i];
            }
        }
    }
}

class bucket {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 1, 5, 5, 3, 7, 3, 6, 8, 2315, 84, 2315, 8486};
        bucketSort bucketSort = new bucketSort();
        bucketSort.bucketSort(arr);
    }
}

*/
/*常见面试题：给定数组，数组元素很长，无法进行排序，求各个元素之间的最大的差值
 *使用桶排序思想
 * 为给定的数字配置捅，桶的个数为数字个数+1
 * 每个桶中仅包含三个属性，是否为空，最大值是多少，最小值是多少
 * 允许捅为空桶
 * 该方法使用放缩，即桶内仅保存最大值和最小值，不同桶之间用前一个的最大值减去下一个桶的最小值得到差值、
 * （注：因为设置了N+1个桶，必然存在最少一个空桶，所以，该桶的大小再加上空桶前一个的最大值和后一个桶的最小值之差，基本就是所求差值*/
class bucket_ {
    /*对于桶内的元素使用三个数组来存储*/
    public static int position(long num, int len, long max, long min) {
        return (int) ((num - min) * len / (max - min));
    }

    public static int bucket(int[] arr) {
        boolean[] hasNum = new boolean[arr.length + 1];
        int[] max = new int[arr.length + 1];
        int[] min = new int[arr.length + 1];
        int bid = 0;
        for (int i = 0; i < arr.length; i++) {
            bid = position(arr[i], arr.length, max[i], min[i]);
            /*更新桶的*/
            max[bid] = hasNum[bid] ? Math.max(max[bid], arr[i]) : arr[i];
            min[bid] = hasNum[bid] ? Math.min(min[bid], arr[i]) : arr[i];
            hasNum[i] = true;
        }

        int lastmax = max[0];
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            /*如果该桶中放过数，进入判断语句*/
            if (hasNum[i]) {
                /*res作为全局变量存储最大值，
                比较方法
                    ——要么是前一个最大值比较大，要么是下个桶的最小值减前一个痛的最大值更大*/
                res = Math.max(res, min[i] - lastmax);
                /*由于必然存在空桶，
                所以不能直接调用上一个数组元素，
                用一个lastmax变量存储上一个有数字桶的最大值*/
                lastmax = max[i];
            }
            return res;
        }
        return bid;
    }
}
