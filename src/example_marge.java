public class example_marge {
    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 7, 2, 1, 8,1,1,5,7,3,6};
        marge(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void marge(int[] arr, int left_point, int right_point) {
        /*由于在递归的时候left_point不一定为0，所以mid不能直接使用长度除以二*/
        int mid = left_point + (right_point - left_point) / 2;
        if (left_point == right_point) {
            return;
        }
        marge(arr, left_point, mid);
        marge(arr, mid + 1, right_point);
        sort(arr, left_point, mid + 1, left_point, right_point);

    }

    public static void sort(int[] arr, int cur_left, int cur_right, int left_point, int right_point) {
        int help[] = new int[arr.length];
        int i = left_point;
        int temp = (left_point+(right_point-left_point)/2);
        while (cur_left <=temp  && cur_right <=right_point) {
            help[i] = arr[cur_left] > arr[cur_right] ? arr[cur_right++] : arr[cur_left++];
            i++;
        }
        while (cur_left <= temp) {
            help[i] = arr[cur_left++];
            i++;
        }
        while (cur_right <= right_point) {
            help[i] = arr[cur_right++];
            i++;
        }
        for (int j = left_point; j <= right_point; j++) {
            arr[j] = help[j];
        }
    }
}
