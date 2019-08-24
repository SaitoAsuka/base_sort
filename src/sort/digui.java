package sort;

public class digui {
    public int[] sort_process(int[] arr, int L, int R) {
        int mid = L + (R - L) / 2;
        if (L == R) {
            return arr;
        }
        sort_process(arr, L, mid);
        sort_process(arr, mid + 1, R);
        merge(arr, L, R, mid);
        return arr;
    }

    private void merge(int[] arr, int l, int r, int mid) {
        int[] help = new int[r];
        int point_l = l;
        int point_r = mid + 1;
        int i = 0;
        /*进行循环，两个数组中必有一个会先越界*/
        while (point_l<=mid&&point_r<=r){
            help[i++]=arr[point_l]<arr[point_r]?arr[point_l++]:arr[point_r++];
        }
        /*当有一个数组越界后，将另外一个数组内的数据再依次传入help数组中*/
        while (point_l<=mid){
            help[i++]=arr[point_l++];
        }
        while (point_r<=r){
            help[i++]=arr[point_r++];
        }

       /* for (int i = 0; i < r + 1; i++) {
            if (arr[point_l] < arr[point_r]) {
                help[i] = arr[point_l];
                point_l++;
            }
            if (arr[point_l] > arr[point_r]) {
                help[i] = arr[point_r];
                point_r++;

            } else {
                help[i] = arr[point_l];
                point_l++;
                point_r++;

            }
        }*/
        for (int j = 0; j < r; j++) {
            arr[j] = help[j];

        }
    }

    public static void main(String[] args) {

    }
}
