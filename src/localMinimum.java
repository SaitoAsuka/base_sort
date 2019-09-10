public class localMinimum {
    /*给定的无序数组，已知数组中任意两个相邻的数不相等，写一个函数，打印出任意一个满足局部最小的下标*/
    /*初始化，begin==0，end==arr.length-1*/
    public static void partSmall(int[] arr, int begin, int end) {
        if (arr[begin] < arr[begin + 1]) {
            System.out.println(arr[begin]);
            return;
        } else if (arr[end - 1] > arr[end]) {
            System.out.println(arr[end]);
            return;
        }
        int mid = 0;
        while (begin < end) {
            mid = (end + begin) / 2;
            if (arr[mid] > arr[mid - 1]) {
                end = mid - 1;
            }else   if (arr[mid] > arr[mid + 1]) {
                begin = mid + 1;
            }   else {
                System.out.println(arr[mid]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 6, 4, 5, 6, 7};
        partSmall(arr, 0, arr.length - 1);
    }
}
