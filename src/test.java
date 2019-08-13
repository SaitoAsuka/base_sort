public class test {
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];/*base_case,*/
        }
        int mid = (L + (R - L) / 2);
        int maxL = getMax(arr, L, mid);
        int maxR = getMax(arr, mid+1,R);
        return Math.max(maxL,maxR);


    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 8, 15, 1, 6};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
    }
}
